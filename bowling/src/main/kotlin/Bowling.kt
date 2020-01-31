class Bowling {
    fun scoreGame(gameResults: String): Int {
        var sum = 0

        for ((index, roll) in gameResults.withIndex()) {

            val currentRollValue = toNumericValue(roll)

            sum += currentRollValue

            sum += addBonus(roll, gameResults, index)
        }

        return sum
    }

    private fun addBonus(roll: Char, gameResults: String, index: Int): Int {
        return when (roll) {
            'X' -> {
                toNumericValue(gameResults[index + 1]) + toNumericValue(gameResults[index + 2])
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
        return when(roll) {
            'X' -> 10
            '/' -> 10
            else -> roll.toString().toInt()
        }
    }
}
