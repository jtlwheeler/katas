class Bowling {
    fun scoreGame(gameResults: String): Int {
        var sum = 0

        for (roll in gameResults) {
            sum += roll.toString().toInt()
        }

        return sum
    }
}
