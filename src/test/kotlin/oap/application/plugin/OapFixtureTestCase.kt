package oap.application.plugin

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import java.io.File

abstract class OapFixtureTestCase : BasePlatformTestCase() {
    override fun setUp() {

        super.setUp()
    }

    override fun getTestDataPath(): String {
        return File("testdata/$basePath").absolutePath
    }

}