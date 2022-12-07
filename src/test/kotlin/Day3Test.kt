import day3.Day3Solution
import org.testng.Assert.assertEquals
import org.testng.annotations.Test

class Day3Test {

    private val day3Solution = Day3Solution()

    @Test
    fun testForFirstTestCase() {
        val expected = 'p'
        assertEquals(day3Solution.findSameChar("vJrwpWtwJgWrhcsFMMfFFhFp"), expected)
    }

    @Test
    fun testForSecondTestCase() {
        val expected = 'L'
        assertEquals(day3Solution.findSameChar("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"), expected)
    }

    @Test
    fun testpValue() {
        val expected = 16
        assertEquals(day3Solution.calculateLowerCasePriority('p'), expected)
    }

    @Test
    fun testvValue() {
        val expected = 22
        assertEquals(day3Solution.calculateLowerCasePriority('v'), expected)
    }

    @Test
    fun testLValue() {
        val expected = 38
        assertEquals(day3Solution.calculateUpperCasePriority('L'), expected)
    }

    @Test
    fun testPValue() {
        val expected = 42
        assertEquals(day3Solution.calculateUpperCasePriority('P'), expected)
    }

    @Test
    fun testFindCommon() {
        val expected = 'r'
        assertEquals(
            day3Solution.findCommon(
                listOf(
                    "vJrwpWtwJgWrhcsFMMfFFhFp",
                    "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                    "PmmdzqPrVvPwwTWBwg"
                )
            ), expected
        )
    }
}