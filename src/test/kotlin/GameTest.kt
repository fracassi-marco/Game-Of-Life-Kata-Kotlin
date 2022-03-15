import org.assertj.core.api.Assertions.assertThat
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
    fun `any live cell with more than three live neighbours dies`() {
        val nextGeneration = Game(
            "***\n" +
            "***"
        ).nextGeneration()

        assertThat(nextGeneration).isEqualTo(
            "*.*\n" +
            "*.*"
        )
    }

    @Test
    fun `live cell with two or three live neighbours lives on to the next generation`() {
        val nextGeneration = Game(
            ".*.\n" +
            ".*.\n" +
            ".*."
        ).nextGeneration()

        assertThat(nextGeneration).isEqualTo(
            "...\n" +
            "***\n" +
            "..."
        )
    }

    @Test
    fun `acceptance test`() {
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