import day8.Day8Solution
import org.testng.Assert
import org.testng.annotations.Test

class Day8Test {

    private val testInput = """
        30373
        25512
        65332
        33549
        35390
    """.trimIndent()

    private val day8Solution = Day8Solution(testInput)

    @Test
    fun testTreeParse() {
        val expected: List<List<Int>> = listOf(
            listOf(
                3, 0, 3, 7, 3
            ),
            listOf(
                2, 5, 5, 1, 2
            ),
            listOf(
                6, 5, 3, 3, 2
            ),
            listOf(
                3, 3, 5, 4, 9
            ),
            listOf(
                3, 5, 3, 9, 0
            ),
        )
        Assert.assertEquals(
            day8Solution.treeHouse,
            expected
        )
    }

    @Test
    fun testGetEdeCount() {
        val expected = 16

        Assert.assertEquals(
            day8Solution.getEdgeCountFromTreeHouse(testInput),
            expected
        )
    }


    @Test
    fun testGetInteriourCount() {
        val expected = 5

        Assert.assertEquals(
            day8Solution.getInteriorCount(testInput),
            expected
        )
    }
}