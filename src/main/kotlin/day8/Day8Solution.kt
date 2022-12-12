package day8

fun main() {
    val day8Solution = Day8Solution(day8Input)
    //println(day8Solution.getEdgeCountFromTreeHouse() + day8Solution.getInteriorCount())
    println(day8Solution.getMaxScenicScore())
}

class Day8Solution(input: String) {

    var treeHouse: List<List<Int>>

    init {
        treeHouse = getTreeHouse(input)
    }

    private fun getTreeHouse(input: String): List<List<Int>> {
        val lines = input.lines()
        val length = lines.first().length
        val treeHouse: MutableList<MutableList<Int>> = MutableList(length) { mutableListOf() }

        lines.forEachIndexed { index, c ->
            c.forEach {
                treeHouse[index].add(it.digitToInt())
            }
        }

        return treeHouse
    }

    fun getEdgeCountFromTreeHouse(): Int {
        return treeHouse.first().count() + treeHouse.last().count() + ((treeHouse.count() - 2) * 2)
    }

    fun getMaxScenicScore(): Int {
        var maxScenicScore = 0

        for (i in 1 until treeHouse.count() - 1) {
            val treeLine = treeHouse[i]

            //From first index
            val treeLineCount = treeLine.count()

            for (j in 1 until treeLineCount - 1) {
                val tree = treeLine[j]
                val treesUntilEnd = treeLine.subList(j + 1, treeLineCount).takeWhile { tree > it }.run {
                    if (isNotEmpty()) {
                        if (last() == treeLine.last()) {
                            count()
                        } else {
                            count() + 1
                        }
                    } else {
                        0
                    }
                }

                val treesUntilStart = treeLine.take(j).takeLastWhile { tree > it }.run {
                    if (isNotEmpty()) {
                        if (first() == treeLine.first()) {
                            count()
                        } else {
                            count() + 1
                        }
                    } else {
                        0
                    }
                }

                val column = treeHouse.mapIndexed { index, treeLines ->
                    Column(index, treeLines[j])
                }
                val columnUntilEnd = column.subList(i + 1, column.count()).takeWhile { tree > it.value }.run {
                    if (isNotEmpty()) {
                        if (last() == column.last()) {
                            count()
                        } else {
                            count() + 1
                        }
                    } else {
                        0
                    }
                }
                val columnUntilIndex = column.take(i).takeLastWhile { tree > it.value }.run {
                    if (isNotEmpty()) {
                        if (first() == column.first()) {
                            count()
                        } else {
                            count() + 1
                        }
                    } else {
                        0
                    }
                }

                if (treesUntilEnd != 0 &&
                    treesUntilStart != 0 &&
                    columnUntilEnd != 0 &&
                    columnUntilIndex != 0
                ) {
                    val scenicScore = treesUntilStart * treesUntilEnd * columnUntilEnd * columnUntilIndex
                    if (scenicScore > maxScenicScore) {
                        maxScenicScore = scenicScore
                    }
                }
            }

        }
        return maxScenicScore
    }

    fun getInteriorCount(): Int {
        var count = 0
        for (i in 1 until treeHouse.count() - 1) {
            val treeLine = treeHouse[i]

            //From first index
            for (j in 1 until treeLine.count() - 1) {
                val tree = treeLine[j]
                val treeLineCount = treeLine.count()

                val treeLineUntilEnd = treeLine.subList(j + 1, treeLineCount)
                val treeLineUntilIndex = treeLine.take(j)

                val column = treeHouse.mapIndexed { index, treeLines ->
                    Column(index, treeLines[j])
                }

                val columnUntilEnd = column.subList(i + 1, column.count())
                val columnUntilIndex = column.take(i)

                if (columnUntilIndex.all { tree > it.value }) {
                    count++
                    continue
                }

                if (columnUntilEnd.all { tree > it.value }) {
                    count++
                    continue
                }

                if (treeLineUntilEnd.all { tree > it }) {
                    count++
                    continue
                }
                if (treeLineUntilIndex.all { tree > it }) {
                    count++
                    continue
                }
            }

        }
        return count
    }

}

data class Column(val index: Int, val value: Int)