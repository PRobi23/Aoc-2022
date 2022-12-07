package day3

fun main() {
    /* val lines = day3Input.split("\n")
     val day3Solution = Day3Solution()
     var count = 0
     lines.forEach { rucksacks ->
         count += day3Solution.calculatePriority(rucksacks)
     }

     println(count)*/
    val day3Solution = Day3Solution()
    val lines2 = day3Input2.split("\n")
    var count2 = 0
    lines2.chunked(3).forEach {
        val badge = day3Solution.findCommon(it)
        count2 += if (badge.isUpperCase()) {
            day3Solution.calculateUpperCasePriority(badge)
        } else {
            day3Solution.calculateLowerCasePriority(badge)
        }
    }
    println(count2)
}

class Day3Solution {

    fun findCommon(rucksacks: List<String>): Char {
        return rucksacks.first().filter(rucksacks[1]::contains).filter(rucksacks[2]::contains).toSet().first()
    }

    fun calculatePriority(rucksacks: String): Int =
        findSameChar(rucksacks).run {
            if (isUpperCase()) {
                calculateUpperCasePriority(this)
            } else {
                calculateLowerCasePriority(this)
            }
        }

    fun findSameChar(rucksacks: String): Char {
        val splitRucksack = rucksacks.count().run {
            rucksacks.chunked(this / 2)
        }

        splitRucksack.first().forEach {
            if (splitRucksack[1].contains(it)) {
                return it
            }
        }
        return 'X'
    }

    fun calculateLowerCasePriority(char: Char): Int {
        return (char.code - 'a'.code) + 1
    }

    //38 is the difference in ASCII code
    fun calculateUpperCasePriority(char: Char): Int {
        return (char.code - 38)
    }
}