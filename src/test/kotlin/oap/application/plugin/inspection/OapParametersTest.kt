package oap.application.plugin.inspection

import com.intellij.psi.PsiFile
import oap.application.plugin.OapFixtureTestCase
import oap.application.plugin.ref.ValidModuleDependsOnInspection
import oap.application.plugin.ref.ValidParametersInspection
import oap.application.plugin.ref.ValidServiceDependsOnInspection

class OapParametersTest : OapFixtureTestCase() {
    protected override fun setUp() {
        super.setUp()

        myFixture.enableInspections(ValidParametersInspection::class.java)
    }

    override fun getBasePath(): String {
        return "inspection"
    }

}