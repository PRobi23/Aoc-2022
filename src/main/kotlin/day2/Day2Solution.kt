package day2

/***
 * A Rock
 * B Paper
 * C Scissors
 */
const val elfRock = "A"
const val elfPaper = "B"
const val elfScissors = "C"

/***
 * X Rock
 * Y Paper
 * Z Scissors
 */
const val myChooseRock = "X"
const val myChoosePaper = "Y"
const val myChooseScissors = "Z"

const val myChooseLose = "X"
const val myChooseDraw = "Y"
const val myChooseWin = "Z"

fun main(args: Array<String>) {
    val lines = day2Input1.split("\n")
    val sum = mutableListOf<Int>()
    lines.forEach {
        it.split(' ').run {
            val elfChoose = first()
            val myChoose = this[1]

            sum.add(calculateScoreSecondPart(elfChoose, myChoose))
        }
    }
    println(sum.sum())
}

/***
 * 1 Rock
 * 2 Paper
 * 3 Scissors
 * 0 Lose
 * 3 Draw
 * 6 Win
 */
fun calculateScoreFirstPart(elfChoose: String, myChoose: String): Int {
    when (elfChoose) {
        elfRock -> {
            return calculateFromMyChoiceRock(myChoose)
        }

        elfPaper -> {
            return calculateFromMyChoicePaper(myChoose)
        }

        elfScissors -> {
            return calculateFromMyChoiceScissors(myChoose)
        }

        else -> return 0
    }
}

private fun calculateFromMyChoiceScissors(myChoose: String): Int {
    return when (myChoose) {
        myChoosePaper -> {
            2 // Lose + Paper 0 + 2
        }

        myChooseScissors -> {
            6 // Draw + Scissors 6 + 3
        }

        else -> {
            7 // Win + Rock 6 + 1
        }
    }
}

private fun calculateFromMyChoicePaper(myChoose: String): Int {
    return when (myChoose) {
        myChoosePaper -> {
            5  // Draw + Paper 3 + 2
        }

        myChooseScissors -> {
            9 // Win + Scissors 6 + 3
        }

        else -> {
            1 // Lose + Rock 0 + 1
        }
    }
}

private fun calculateFromMyChoiceRock(myChoose: String): Int {
    return when (myChoose) {
        myChoosePaper -> {
            8 // Win + Paper 6 + 2
        }

        myChooseScissors -> {
            3 // Lose + Scissors 0 + 3
        }

        else -> {
            4 // Draw + Rock 3 + 1
        }
    }
}

/***
 * 1 Rock
 * 2 Paper
 * 3 Scissors
 * 0 Lose
 * 3 Draw
 * 6 Win
 */
fun calculateScoreSecondPart(elfChoose: String, myChoose: String): Int {
    when (elfChoose) {
        elfRock -> {
            return calculateFromResultForRock(myChoose)
        }

        elfPaper -> {
            return calculateFromResultForPaper(myChoose)
        }

        elfScissors -> {
            return calculateFromResultScissors(myChoose)
        }

        else -> return 0
    }
}

private fun calculateFromResultScissors(myChoose: String): Int {
    return when (myChoose) {
        myChooseLose -> {
            2 // Lose + Paper 0 + 2
        }

        myChooseDraw -> {
            6 // Draw + Scissors 6 + 3
        }

        else -> {
            7 // Win + Rock 6 + 1
        }
    }
}

private fun calculateFromResultForPaper(myChoose: String): Int {
    return when (myChoose) {
        myChooseDraw -> {
            5  // Draw + Paper 3 + 2
        }

        myChooseWin -> {
            9 // Win + Scissors 6 + 3
        }

        else -> {
            1 // Lose + Rock 0 + 1
        }
    }
}

private fun calculateFromResultForRock(myChoose: String): Int {
    return when (myChoose) {
        myChooseWin -> {
            8 // Win + Paper 6 + 2
        }

        myChooseLose -> {
            3 // Lose + Scissors 0 + 3
        }

        else -> {
            4 // Draw + Rock 3 + 1
        }
    }
}
