package oap.application.plugin.parser

import com.intellij.psi.PsiFile
import com.intellij.psi.impl.DebugUtil
import junit.framework.TestSuite
import oap.application.plugin.OapFileSetTestCase
import org.junit.runner.RunWith
import org.junit.runners.AllTests

@RunWith(AllTests::class)
class OapParserTest : OapFileSetTestCase("parser") {
    override fun transform(data: Array<String>): String {
        val psiFile: PsiFile = createPseudoPhysicalOapFile(data[0])
        return DebugUtil.psiToString(psiFile, true).replace(":" + psiFile.getName(), "")
    }

    companion object {
        @JvmStatic
        fun suite(): TestSuite {
            val suite = TestSuite()

            suite.addTest(OapParserTest())

            return suite
        }
    }
}