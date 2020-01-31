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

}
