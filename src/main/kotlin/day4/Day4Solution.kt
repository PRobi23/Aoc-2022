package day4

import day4Input

fun main() {
    val day4Solution = Day4Solution()
    val lines = day4Input.split("\n").map {
        it.asRanges()
    }
    /*var count = 0
    lines.forEach {
        if (it.first fullyOverlaps it.second || it.second fullyOverlaps it.first) {
            count++
        }
    }*/
    println(lines.count { pair ->
        pair.first overlaps pair.second
    })
}

fun String.asRanges(): Pair<IntRange, IntRange> =
    substringBefore(',').asIntRange() to substringAfter(',').asIntRange()

fun String.asIntRange(): IntRange =
    substringBefore('-').toInt()..substringAfter('-').toInt()

infix fun IntRange.fullyOverlaps(other: IntRange): Boolean =
    first <= other.first && last >= other.last

infix fun IntRange.overlaps(other: IntRange): Boolean =
    first <= other.last && other.first <= last

class Day4Solution {

    fun oneIntRangeContainsOther(firstRange: String, secondRange: String): Boolean {
        val firstSet = parseFromString(firstRange)
        val secondSet = parseFromString(secondRange)
        return firstSet fullyOverlaps secondSet || secondSet fullyOverlaps firstSet
    }

    fun parseFromString(range: String): IntRange {
        return if (range.contains('-')) {
            val startNum = range.first().digitToInt()
            val endNum = range.substringAfter('-').toInt()
            val numSet = mutableSetOf<Int>()
            for (i in startNum..endNum) {
                numSet.add(i)
            }
            startNum..endNum
        } else {
            val startNum = range.first().digitToInt()
            val endNum = range.substringAfter('-').toInt()

            return startNum..endNum
        }
    }

}