class Bowling {
    fun scoreGame(gameResults: String): Int {
        var sum = 0

        for ((index, roll) in gameResults.withIndex()) {

            val currentRollValue = toNumericValue(roll)

            sum += currentRollValue

            if (index < 20) {
                sum += addBonus(roll, gameResults, index)
            }
        }

        return sum
    }

    private fun addBonus(roll: Char, gameResults: String, index: Int): Int {
        return when (roll) {
            'X' -> {
                val nextRoll = gameResults[index + 2]
                if (nextRoll == 'X') {
                    val nextNextRoll = gameResults[index + 3]
                    if (index < 18) {
                        val nextNextNextRoll = gameResults[index + 4]
                        if (nextNextNextRoll == 'X') {
                            toNumericValue(nextRoll) + toNumericValue(nextNextNextRoll)
                        } else {
                            toNumericValue(nextRoll) + toNumericValue(nextNextRoll)
                        }
                    } else {
                       0
                    }
                } else {
                    val twoRollsAhead = gameResults[index + 2]
                    toNumericValue(nextRoll) + toNumericValue(twoRollsAhead)
                }
            }
            '/' -> {
                toNumericValue(gameResults[index + 1])
            }
            else -> {
                0
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
