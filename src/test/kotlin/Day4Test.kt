import day4.Day4Solution
import day4.overlaps
import org.testng.Assert
import org.testng.annotations.Test

class Day4Test {

    private val day4Solution = Day4Solution()

    @Test
    fun testForFirstTestCase() {
        Assert.assertFalse(day4Solution.oneIntRangeContainsOther(firstRange = "2-6", secondRange = "4-8"))
    }

    @Test
    fun testForSecondTestCase() {
        Assert.assertTrue(day4Solution.oneIntRangeContainsOther(firstRange = "6-6", secondRange = "4-6"))
    }

    @Test
    fun testForThirdTestCase() {
        Assert.assertTrue(day4Solution.oneIntRangeContainsOther(firstRange = "26-94", secondRange = "26-94"))
    }

    @Test
    fun testContainsTestCase() {
        Assert.assertTrue(day4Solution.oneIntRangeContainsOther(firstRange = "2-8", secondRange = "3-7"))
    }

    @Test
    fun testNotContainsTestCase() {
        Assert.assertFalse(day4Solution.oneIntRangeContainsOther(firstRange = "2-3", secondRange = "4-5"))
    }

    @Test
    fun testParseFromSingleString() {
        val expected = setOf(6)
        Assert.assertEquals(day4Solution.parseFromString("6"), expected)
    }

    @Test
    fun testParseFromRangeString() {
        val expected = setOf(1, 2, 3, 4, 5, 6)
        Assert.assertEquals(day4Solution.parseFromString("1-6"), expected)
    }

    @Test
    fun testOverlap() {
        val expected = 1
        Assert.assertEquals(expected, 5 .. 7  overlaps 7 .. 9)
    }
}