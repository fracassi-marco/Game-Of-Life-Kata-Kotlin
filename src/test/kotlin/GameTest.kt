import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `top left dead cell becomes a live cell`() {
        val nextGeneration = Game(
            ".*\n" +
            "**"
        ).nextGeneration()

        assertThat(nextGeneration).isEqualTo(
            "**\n" +
            "**"
        )
    }

    @Test
    fun `top right dead cell becomes a live cell`() {
        val nextGeneration = Game(
            "*.\n" +
            "**"
        ).nextGeneration()

        assertThat(nextGeneration).isEqualTo(
            "**\n" +
            "**"
        )
    }

    @Test
    @Disabled
    fun acceptanceTest() {
        val nextGeneration = Game(
            """........
               ....*...
               ...**...
               ........""".trimIndent()
        ).nextGeneration()

        assertThat(nextGeneration).isEqualTo(
            """........
               ...**...
               ...**...
               ........""".trimIndent()
        )
    }
}