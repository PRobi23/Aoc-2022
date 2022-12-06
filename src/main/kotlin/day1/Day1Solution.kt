package day1

fun main(args: Array<String>) {

    val lines = day1Input.split("\n")
    val elfs = mutableListOf<Int>()

    for ((i, line) in lines.withIndex()) {
        var j = i + 1
        if(line != "") {
            var calories = line.toInt()
            while (lines[j] != "") {
                calories += lines[j].toInt()
                j++
            }

            elfs.add(calories)
        }
    }

    println(elfs.max())
}