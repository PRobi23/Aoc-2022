package day6

fun main() {
    val day6Solution = Day6Solution()
    println(day6Solution.findFirstFourUniqueCharactersNumber(day6Input, 14))
}

class Day6Solution {
    fun findFirstFourUniqueCharactersNumber(input: String, numberCheck: Int = 4): Int {
        input.forEachIndexed { index, _ ->
            if (input.substring(index, index + numberCheck).toSet().count() == numberCheck) {
                return index + numberCheck
            }
        }
        return 0
    }
}