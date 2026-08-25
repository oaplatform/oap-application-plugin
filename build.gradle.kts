plugins {
    id("java")
    id("idea")
    id("org.jetbrains.kotlin.jvm") version "2.2.21"
    id("org.jetbrains.intellij.platform") version "2.18.1"
    id("org.jetbrains.intellij.platform.grammarkit") version "2.18.1"
}

group = "oap"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

java.sourceSets["main"].java {
    srcDir("gen")
}

idea.module.generatedSourceDirs.add(file("gen"))

// Configure IntelliJ Platform Gradle Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html
dependencies {
    intellijPlatform {
        create("IC", "2025.1.4.1")
        testFramework(org.jetbrains.intellij.platform.gradle.TestFrameworkType.Platform)

        bundledPlugin("com.intellij.java")

        // Add necessary plugin dependencies for compilation here, example:
        // bundledPlugin("com.intellij.java")

        grammarKit()
        jflex()
    }

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.opentest4j:opentest4j:1.3.0")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("io.github.java-diff-utils:java-diff-utils:4.16")
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "251"
        }

        changeNotes = """
            Initial version
        """.trimIndent()
    }
}

// Regenerates gen/oap/application/plugin/gen/{parser,psi}/** from grammars/oap.bnf and grammars/_OapLexer.flex.
// Each task's purge (default on) is scoped to only pathToParser+pathToPsiRoot / pathToClass respectively,
// so the two tasks don't clobber each other's output regardless of run order.
//
// generateParser needs oap.application.plugin.psi.impl.GrammarPsiImplUtil (psiImplUtilClass in oap.bnf) on
// its classpath to detect mixin method signatures (getServices, getBooleanValue, etc.) - without it, those
// methods are silently omitted from the generated PSI and callers fail to compile. That class lives in our
// own main sourceSet, so it reads whatever compileKotlin/compileJava last produced in build/classes - which
// is also why these tasks call doNotTrackState(): both compileJava/compileKotlin and generateParser touch
// each other's output directories (gen/ and build/classes), and wiring that as a real dependsOn either way
// creates a genuine cycle (generateParser needs compiled mixin classes; compiling needs generateParser's
// output). Regenerate manually after editing grammars/*.bnf or *.flex with
// `./gradlew generateParser generateLexer`, then do a normal build/test run to pick up the new grammar.
tasks.generateParser {
    sourceFile.set(file("grammars/oap.bnf"))
    targetRootOutputDir.set(file("gen"))
    pathToParser.set("oap/application/plugin/gen/parser/OapParser.java")
    pathToPsiRoot.set("oap/application/plugin/gen/psi")
    classpath += sourceSets["main"].compileClasspath +
        files(layout.buildDirectory.dir("classes/kotlin/main")) +
        files(layout.buildDirectory.dir("classes/java/main")) +
        files(layout.buildDirectory.dir("instrumented/instrumentCode"))
    doNotTrackState("regenerates grammar sources independently of the normal compile graph - see comment above")
}

tasks.generateLexer {
    sourceFile.set(file("grammars/_OapLexer.flex"))
    targetRootOutputDir.set(file("gen"))
    pathToClass.set("oap/application/plugin/gen/parser/_OapLexer.java")
    doNotTrackState("regenerates grammar sources independently of the normal compile graph - see comment above")
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }

    test {
        environment("NO_FS_ROOTS_ACCESS_CHECK", "true")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xwhen-guards")
        freeCompilerArgs.add("-Xjvm-default=all")
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}
