# OAP Application Plugin

IntelliJ Platform plugin with IDE support for `.oap` files. These are module descriptors for the
[OAP](https://www.oaplatform.org) IoC/DI kernel. Each one declares an application module, its services,
dependencies and configurations.

- Plugin id: `oap`
- Version: see `version` in `gradle.properties`
- Compatibility: IntelliJ IDEA 2025.1+ (build 251+); Java features need the bundled Java plugin

## The `.oap` language

Language reference: [OAP Application](https://github.com/oaplatform/oap#oap-application).

A file describes one module. Brace (HOCON-like) and YAML-style colon/indent syntax can be mixed freely:

```
name = my-module
enabled = true
dependsOn = [oap-ws, other-module]
include required("shared.conf")

services {
  my-service {
    implementation = com.example.MyService
    parameters {
      timeout = 10s
      listener = <modules.this.other-service>
    }
    supervision.supervise = true
  }
}

configurations = [{
  loader = com.example.MyLoader
  config { key = value }
}]
```

The same thing in YAML style:

```
name: my-module
services:
  my-service:
    implementation = com.example.MyService
    parameters:
      filters:
        - <modules.this.filter-a>
        - <modules.this.filter-b>
      description: |
        multi-line
        block scalar
```

Supported syntax:
- `=` and `:` assignment
- `{}` objects and `:` indented blocks
- `[]` arrays and `-` dash lists
- `|` / `>` block scalars
- `<modules.X.Y>` / `<services.self.X>` / `<kernel.self>` references
- `${ENV}` values
- `//` and `#` comments

## Features

- **Highlighting**:
  - lexer-based highlighting plus an annotator
  - configurable colors (Settings > Editor > Color Scheme > OAP)
- **Navigation (Go To Declaration)**:
  - module names in `dependsOn` and references (resolved through a stub index)
  - service names
  - `include required("...")` files
  - Java classes in `implementation` / `loader`
  - `parameters` keys to the Java setter, constructor parameter or field
- **Completion**:
  - keywords
  - module/service references
  - Java parameter names
  - `supervision` entries
- **Inspections**:
  - unknown classes
  - unknown modules/services in `dependsOn` and references
  - unknown parameters
  - missing includes
- **Refactoring**: renaming a Java field, parameter or setter updates the matching `parameters` keys in `.oap` files.
- **Editor**:
  - formatter with code style settings
  - brace matching
  - folding
  - line comment/uncomment
  - breadcrumbs
  - structure view
  - service line markers, in both `.oap` and Java
- **oap-ws `@WsValidate`** (Java): navigation, completion and shape validation for validator method names.

## Build and test

Requires Java 21.

```bash
./gradlew build            # build the plugin (zip in build/distributions/)
./gradlew test             # run all tests
./gradlew test --tests "oap.application.plugin.parser.OapParserTest"
./gradlew runIde           # start a sandbox IDE with the plugin installed
```

### Grammar changes

These files are the source of the language:
- `grammars/oap.bnf` (Grammar-Kit)
- `grammars/_OapLexer.flex` (JFlex)

The parser, lexer and PSI classes in `gen/` are generated from them, so never edit `gen/` by hand.
After editing either grammar file:

1. `./gradlew generateParser generateLexer`
2. Bump `VERSION` in `src/main/kotlin/oap/application/plugin/stub/types/OapFileElementType.kt`, so IDEA
   rebuilds stale stub indexes. Without this, users get `UpToDateStubIndexMismatch`.
3. Add or update parser fixtures in `testdata/parser/` and run the tests.

## Project layout

| Path | Contents |
|---|---|
| `grammars/` | BNF grammar and JFlex lexer |
| `gen/` | Generated parser, lexer, PSI |
| `src/main/kotlin/oap/application/plugin/` | Plugin code: `lang`, `lexer`, `parser`, `psi`, `highlight`, `completion`, `ref` (references + inspections), `formatter`, `editor`, `stub`, `structure`, `misc` |
| `src/main/resources/META-INF/plugin.xml` | Extension registrations |
| `src/test/kotlin/` | Tests (`BasePlatformTestCase` via `OapFixtureTestCase`) |
| `testdata/<category>/` | Test fixtures: `.oap` input + expected `.txt` PSI trees |

## Testing

Parser tests compare the PSI tree of `testdata/parser/X.oap` with `X.txt`. On first run a missing `.txt`
is generated and the test fails once. Review the generated file, then rerun.
`OapStubConsistencyTest` checks that the stub tree matches the AST for every parser fixture.
