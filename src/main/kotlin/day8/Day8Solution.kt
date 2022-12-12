package day8

fun main() {

    val day8Solution = Day8Solution(day8Input)
    println(day8Solution.getEdgeCountFromTreeHouse(day8Input) + day8Solution.getInteriorCount(day8Input))
}

class Day8Solution(val input: String) {

    lateinit var treeHouse: List<List<Int>>

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

    fun getEdgeCountFromTreeHouse(input: String): Int {
        return treeHouse.first().count() + treeHouse.last().count() + ((treeHouse.count() - 2) * 2)
    }

    fun getInteriorCount(input: String): Int {
        var count = 0
        for (i in 1 until treeHouse.count() - 1) {
            val treeLine = treeHouse[i]

            //From first index
            for (j in 1 until treeLine.count() - 1) {
                val tree = treeLine[j]
                val treeLineCount = treeLine.count()

                val treeLineUntilEnd = treeLine.subList(j + 1, treeLineCount)
                val treeLineUntilIndex = treeLine.take(j)

                if (treeLineUntilEnd.all { tree > it }) {
                    count++
                    continue
                }
                if (treeLineUntilIndex.all { tree > it }) {
                    count++
                    continue
                }

                val column = treeHouse.mapIndexed { index, treeLines ->
                    Column(index, treeLines[j])
                }

                val columnUntilEnd = column.subList(i, column.count())
                val columnUntilIndex = column.take(i)

                if (columnUntilIndex.all { tree > it.value }) {
                    count++
                    continue
                }

                if (columnUntilEnd.all { tree > it.value }) {
                    count++
                    continue
                }
            }

        }
        return count
    }

}

data class Column(val index: Int, val value: Int)