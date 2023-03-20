package mozio

class MozioChallenge {

    fun exchangeStamps(jane: Array<Int>, alice: Array<Int>): Pair<Array<Int>, Array<Int>> {
        // Initialize empty maps to keep track of the stamps
        val janeStamps = countOccurrencesOfStamp(jane)
        val aliceStamps = countOccurrencesOfStamp(alice)

        // Find the stamps to exchange for each person
        val janeExchange = stampsToExchange(janeStamps, aliceStamps)
        val aliceExchange = stampsToExchange(aliceStamps, janeStamps)

        // Return the arrays of stamps to exchange
        return Pair(janeExchange.toTypedArray(), aliceExchange.toTypedArray())
    }

    private fun countOccurrencesOfStamp(input: Array<Int>): Map<Int, Int> {
        val stamps = mutableMapOf<Int, Int>()

        for (stamp in input) {
            stamps[stamp] = stamps.getOrDefault(stamp, 0) + 1
        }

        return stamps
    }

    private fun stampsToExchange(existingStamps: Map<Int, Int>, otherPersonsStamps: Map<Int, Int>): List<Int> {
        val exchange = mutableListOf<Int>()
        for ((stamp, count) in existingStamps) {
            if (otherPersonsStamps.getOrDefault(stamp, 0) <= 1 && count > 1) {
                exchange.add(stamp)
            }
        }
        return exchange
    }
}