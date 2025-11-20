package oap.application.plugin

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import oap.application.plugin.ref.ValidModuleDependsOnInspection
import java.io.File

abstract class OapFixtureTestCase : BasePlatformTestCase() {
    override fun setUp() {
        super.setUp()

        myFixture.enableInspections(ValidModuleDependsOnInspection::class.java)
    }

    override fun getTestDataPath(): String {
        return File("testdata/$basePath").absolutePath
    }

}