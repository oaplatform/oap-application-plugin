package oap.application.plugin.manipulators

import com.intellij.openapi.util.TextRange
import com.intellij.psi.ElementManipulator
import com.intellij.psi.ElementManipulators
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import junit.framework.TestSuite
import oap.application.plugin.OapFileSetTestCase
import oap.application.plugin.psi.OapKeyValueClass
import org.junit.runner.RunWith
import org.junit.runners.AllTests
import kotlin.reflect.KClass

abstract class OapManipulatorTest : OapFileSetTestCase("manipulators") {
    override fun transform(data: Array<String>): String {
        val inputCaret: String = data.first();
        val newContentInBrackets: String = data.last()
        val (input: String, offset: Int) = extractCaret(inputCaret)
        val newContent: String = newContentInBrackets.removePrefix("[").removeSuffix("]")

        val psiFile: PsiFile = createPseudoPhysicalOapFile(input)

        inWriteCommandAction {
            val manipulator: Pair<PsiElement, ElementManipulator<PsiElement>> = generateSequence(psiFile.findElementAt(offset)) { it.parent }
                .map { Pair(it, ElementManipulators.getManipulator(it)) }
                .filter{it.second != null}
                .first()

            val range: TextRange = manipulator.second.getRangeInElement(manipulator.first)
            manipulator.second.handleContentChange(manipulator.first, range, newContent)
        }

        return psiFile.getText()
    }
}

@RunWith(AllTests::class)
class OapImplementationManipulatorTest : OapManipulatorTest() {
    companion object {
        @JvmStatic
        fun suite(): TestSuite {
            val suite: TestSuite = TestSuite()

            suite.addTest(OapImplementationManipulatorTest())

            return suite
        }
    }
}
