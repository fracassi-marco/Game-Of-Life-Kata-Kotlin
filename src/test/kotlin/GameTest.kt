import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `any dead cell with exactly three live neighbours becomes a live cell`() {
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
    fun `any live cell with fewer than two live neighbours dies`() {
        val nextGeneration = Game(
            "*.\n" +
            ".."
        ).nextGeneration()

        assertThat(nextGeneration).isEqualTo(
            "..\n" +
            ".."
        )
    }

    @Test
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