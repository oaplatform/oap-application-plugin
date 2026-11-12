package oap.application.plugin.editor

import oap.application.plugin.OapFixtureTestCase
import org.assertj.core.api.Assertions.assertThat

class JavaOapServiceLineMarkerTest : OapFixtureTestCase() {
    override fun setUp() {
        super.setUp()
        myFixture.addFileToProject(
            "oap-module.oap",
            """
            name = test-module
            services {
              used-service {
                implementation = test.Used
              }
            }
            """.trimIndent()
        )
    }

    private fun serviceMarkers(): List<String?> =
        myFixture.findAllGutters()
            .map { it.tooltipText }
            .filter { it == "Service implementation" }

    fun testUsedClassHasMarker() {
        myFixture.configureByText("Used.java", "package test; public class Used {}")
        assertThat(serviceMarkers()).hasSize(1)
    }

    fun testUnusedClassHasNoMarker() {
        myFixture.configureByText("Unused.java", "package test; public class Unused {}")
        assertThat(serviceMarkers()).isEmpty()
    }
}
