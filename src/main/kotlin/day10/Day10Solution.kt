package day10

fun main() {
    val lines = day10Input.lineSequence()
    val day10Solution = Day10Solution()
    val values = day10Solution.parseCommands(lines)

    val count = day10Solution.getSum(values)
    println(count)
}

class Day10Solution {
    private val specialNumbers = listOf(20, 60, 100, 140, 180, 220)

    fun parseCommands(input: Sequence<String>): Map<Int, Int> {

        var actualValue = 1
        var cycle = 1
        val cycleValues = mutableMapOf<Int, Int>()

        input.forEach { commandString ->
            cycle++
            when (val command = commandString.parseToCommand()) {
                is Command.NoOperation -> {
                    cycleValues[cycle] = actualValue
                }

                is Command.Add -> {
                    cycleValues[cycle] = actualValue
                    cycle++
                    actualValue += command.num

                    cycleValues[cycle] = actualValue
                }
            }
        }
        return cycleValues
    }

    fun getSum(cycleValues: Map<Int, Int>): Int =
        specialNumbers.map { specialNumber ->
            cycleValues[specialNumber]?.let {
                it * specialNumber
            } ?: 0
        }.sumOf {
            it
        }
}

sealed class Command {
    object NoOperation : Command()

    class Add(val num: Int) : Command()
}

fun String.parseToCommand(): Command =
    if (this == "noop") {
        Command.NoOperation
    } else {
        Command.Add(this.substringAfter("addx ").toInt())
    }