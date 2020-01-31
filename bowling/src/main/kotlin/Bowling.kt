class Bowling {
    fun scoreGame(gameResults: String): Int {
        var sum = 0

        for (roll in gameResults) {
            sum += if (roll == '/') {
                10
            } else {
                roll.toString().toInt()
            }

        }

        return sum
    }
}
