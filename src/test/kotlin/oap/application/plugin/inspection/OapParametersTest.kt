package oap.application.plugin.inspection

import oap.application.plugin.OapFixtureTestCase
import oap.application.plugin.ref.ValidParametersInspection

class OapParametersTest : OapFixtureTestCase() {
    protected override fun setUp() {
        super.setUp()

        myFixture.enableInspections(ValidParametersInspection::class.java)
    }

    override fun getBasePath(): String {
        return "inspection"
    }

    fun testParameterAsField() {

    }
}