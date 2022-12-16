import day10.Day10Solution
import org.testng.Assert
import org.testng.annotations.Test

class Day10Test {

    private val testInput = """
        addx 15
        addx -11
        addx 6
        addx -3
        addx 5
        addx -1
        addx -8
        addx 13
        addx 4
        noop
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx -35
        addx 1
        addx 24
        addx -19
        addx 1
        addx 16
        addx -11
        noop
        noop
        addx 21
        addx -15
        noop
        noop
        addx -3
        addx 9
        addx 1
        addx -3
        addx 8
        addx 1
        addx 5
        noop
        noop
        noop
        noop
        noop
        addx -36
        noop
        addx 1
        addx 7
        noop
        noop
        noop
        addx 2
        addx 6
        noop
        noop
        noop
        noop
        noop
        addx 1
        noop
        noop
        addx 7
        addx 1
        noop
        addx -13
        addx 13
        addx 7
        noop
        addx 1
        addx -33
        noop
        noop
        noop
        addx 2
        noop
        noop
        noop
        addx 8
        noop
        addx -1
        addx 2
        addx 1
        noop
        addx 17
        addx -9
        addx 1
        addx 1
        addx -3
        addx 11
        noop
        noop
        addx 1
        noop
        addx 1
        noop
        noop
        addx -13
        addx -19
        addx 1
        addx 3
        addx 26
        addx -30
        addx 12
        addx -1
        addx 3
        addx 1
        noop
        noop
        noop
        addx -9
        addx 18
        addx 1
        addx 2
        noop
        noop
        addx 9
        noop
        noop
        noop
        addx -1
        addx 2
        addx -37
        addx 1
        addx 3
        noop
        addx 15
        addx -21
        addx 22
        addx -6
        addx 1
        noop
        addx 2
        addx 1
        noop
        addx -10
        noop
        noop
        addx 20
        addx 1
        addx 2
        addx 2
        addx -6
        addx -11
        noop
        noop
        noop
    """.trimIndent()

    private val smallTest = """
        noop
        addx 3
        addx -5
    """.trimIndent()

    private val day10Solution = Day10Solution()

    @Test
    fun testParsing() {
        val expected =
            mapOf(
                2 to 1,
                3 to 4,
                4 to 4,
                5 to -1,
                6 to -1
            )

        Assert.assertEquals(
            expected, day10Solution.parseCommands(smallTest.lineSequence())
        )
    }

    @Test
    fun test20Value() {
        val expected = 21
        val values = day10Solution.parseCommands(testInput.lineSequence())

        Assert.assertEquals(expected, values.getValue(20))
    }

    @Test
    fun test60Value() {
        val expected = 19
        val values = day10Solution.parseCommands(testInput.lineSequence())

        Assert.assertEquals(expected, values.getValue(60))
    }

    @Test
    fun test100Value() {
        val expected = 18
        val values = day10Solution.parseCommands(testInput.lineSequence())

        Assert.assertEquals(expected, values.getValue(100))
    }

    @Test
    fun test140Value() {
        val expected = 21
        val values = day10Solution.parseCommands(testInput.lineSequence())

        Assert.assertEquals(expected, values.getValue(140))
    }

    @Test
    fun test180Value() {
        val expected = 16
        val values = day10Solution.parseCommands(testInput.lineSequence())

        Assert.assertEquals(expected, values.getValue(180))
    }

    @Test
    fun test220Value() {
        val expected = 18
        val values = day10Solution.parseCommands(testInput.lineSequence())

        Assert.assertEquals(expected, values.getValue(220))
    }

}