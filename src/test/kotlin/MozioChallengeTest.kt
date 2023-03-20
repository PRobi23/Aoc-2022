import mozio.MozioChallenge
import org.testng.Assert
import org.testng.annotations.Test

class MozioChallengeTest {

    private val sut = MozioChallenge()

    @Test
    fun first_input_should_give_valid_output() {
        val expected = Pair(arrayOf(1, 7), arrayOf(2, 3))
        val jane = arrayOf(1, 7, 3, 1, 7, 4, 5, 1, 7, 1)
        val alice = arrayOf(2, 3, 3, 2, 4, 3, 2)
        val result = sut.exchangeStamps(
            jane,
            alice
        )
        Assert.assertEquals(expected.first, result.first)
        Assert.assertEquals(expected.second, result.second)
    }

    @Test
    fun second_input_should_give_valid_output() {
        val expected = emptyArray<Int>() to emptyArray<Int>()
        val jane = arrayOf(1, 2, 3, 4, 4)
        val alice = arrayOf(4, 4, 4, 5, 6, 7)
        val result = sut.exchangeStamps(
            jane,
            alice
        )
        Assert.assertEquals(expected.first, result.first)
        Assert.assertEquals(expected.second, result.second)
    }

    @Test
    fun third_input_should_give_valid_output() {
        val expected = arrayOf(4, 3) to emptyArray<Int>()
        val jane = arrayOf(5, 4, 4, 3, 3, 3, 3)
        val alice = arrayOf(1, 3)
        val result = sut.exchangeStamps(
            jane,
            alice
        )
        Assert.assertEquals(expected.first, result.first)
        Assert.assertEquals(expected.second, result.second)
    }
}