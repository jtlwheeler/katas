import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class BowlingTest {

    @Test
    fun `when all zeros are rolled, then the final score is 0`() {
        val gameResults = "00000000000000000000"

        val bowling = Bowling()
        val score = bowling.scoreGame(gameResults)

        assertThat(score).isEqualTo(0)
    }

    @Test
    fun `when all 1 are rolled, then the final score is 20`() {
        val gameResults = "11111111111111111111"

        val bowling = Bowling()
        val score = bowling.scoreGame(gameResults)

        assertThat(score).isEqualTo(20)
    }

    @Test
    fun `when all spares are rolled on the second roll of each frame, then the final score is 100`() {
        val gameResults = "0/0/0/0/0/0/0/0/0/0/0"

        val bowling = Bowling()
        val score = bowling.scoreGame(gameResults)

        assertThat(score).isEqualTo(100)
    }

    @Test
    fun `when spares are rolled, then the final score is calculated properly`() {
        val gameResults = "1/1/1/1/1/1/1/1/1/1/1"

        val bowling = Bowling()
        val score = bowling.scoreGame(gameResults)

        assertThat(score).isEqualTo(121)
    }

}
