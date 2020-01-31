class Bowling {
    fun scoreGame(gameResult: String): Int {
        var sum = 0

        for ((index, roll) in gameResult.withIndex()) {

            val currentRollValue = toNumericValue(roll)

            val currentFrameIsSpare = index < gameResult.length - 1 && gameResult[index + 1] == '/'
            if (currentFrameIsSpare) {
                continue
            }

            sum += currentRollValue
            sum += calculateBonus(roll, gameResult, index)
        }

        return sum
    }

    private fun calculateBonus(roll: Char, gameResults: String, index: Int): Int {
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
        val isBonusFrame = index >= 18
        if (isBonusFrame) {
            return 0
        }

        val firstRollOfNextFrame = gameResult[index + 2]

        val nextFrameIsSpare = gameResult[index + 3] == '/'
        return when {
            nextFrameIsSpare -> {
                10
            }
            firstRollOfNextFrame == 'X' -> {
                val nextNextRoll = gameResult[index + 4]
                toNumericValue(firstRollOfNextFrame) + toNumericValue(nextNextRoll)
            }
            else -> {
                val twoRollsAhead = gameResult[index + 2]
                toNumericValue(firstRollOfNextFrame) + toNumericValue(twoRollsAhead)
            }
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
