class Bowling {
    fun scoreGame(gameResult: String): Int {
        var sum = 0

        for ((index, roll) in gameResult.withIndex()) {

            val currentRollValue = toNumericValue(roll)

            sum += currentRollValue

            if (index < 20) {
                sum += addBonus(roll, gameResult, index)
            }
        }

        return sum
    }

    private fun addBonus(roll: Char, gameResults: String, index: Int): Int {
        return when (roll) {
            'X' -> {
                calculateStrikeBonus(gameResults, index)
            }
            '/' -> {
                calculateSpareBonus(gameResults, index)
            }
            else -> {
                0
            }
        }
    }

    private fun calculateSpareBonus(gameResult: String, index: Int) = toNumericValue(gameResult[index + 1])

    private fun calculateStrikeBonus(gameResult: String, index: Int): Int {
        if (index >= 18) {
            return 0
        }

        val nextRoll = gameResult[index + 2]
        return if (nextRoll == 'X') {
            val nextNextRoll = gameResult[index + 4]
            toNumericValue(nextRoll) + toNumericValue(nextNextRoll)
        } else {
            val twoRollsAhead = gameResult[index + 2]
            toNumericValue(nextRoll) + toNumericValue(twoRollsAhead)
        }
    }

    private fun toNumericValue(roll: Char): Int {
        return when (roll) {
            'X' -> 10
            '/' -> 10
            else -> roll.toString().toInt()
        }
    }
}
