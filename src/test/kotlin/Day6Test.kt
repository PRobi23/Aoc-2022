import day6.Day6Solution
import org.testng.Assert
import org.testng.annotations.Test

class Day6Test {

    private val day6Solution = Day6Solution()

    @Test
    fun testFindFirstFourUniqueCharactersNumber() {
        val expected = 7
        Assert.assertEquals(
            day6Solution.findFirstFourUniqueCharactersNumber("mjqjpqmgbljsphdztnvjfqwrcgsmlb"),
            expected
        )
    }

    @Test
    fun test2FindFirstFourUniqueCharactersNumber() {
        val expected = 5
        Assert.assertEquals(
            day6Solution.findFirstFourUniqueCharactersNumber("bvwbjplbgvbhsrlpgdmjqwftvncz"),
            expected
        )
    }

    @Test
    fun testPart2FindFirstFourUniqueCharactersNumber() {
        val expected = 19
        Assert.assertEquals(
            day6Solution.findFirstFourUniqueCharactersNumber("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 14),
            expected
        )
    }
}