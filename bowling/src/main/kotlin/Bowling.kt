class Bowling {
    fun scoreGame(gameResults: String): Int {
        var sum = 0

        for ((index, roll) in gameResults.withIndex()) {
            sum += if (roll == 'X') {
                10 + gameResults[index + 1].toString().toInt() + gameResults[index + 2].toString().toInt()
            } else if (roll == '/') {
                10 + gameResults[index + 1].toString().toInt()
            } else {
                roll.toString().toInt()
            }

        }

        return sum
    }
}
