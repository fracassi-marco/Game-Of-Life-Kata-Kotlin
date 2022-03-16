import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FrameTest {

    @Test
    fun full() {
        val board = listOf(
            listOf("*", "*", "*"),
            listOf("*", ".", "*"),
            listOf("*", "*", "*"),
        )

        val count = Frame(board).countLiveNeighboursOf(1, 1)

        assertThat(count).isEqualTo(8)
    }

    @Test
    fun `partial on bottom right`() {
        val board = listOf(
            listOf(".", "*"),
            listOf("*", "*")
        )

        val count = Frame(board).countLiveNeighboursOf(0, 0)

        assertThat(count).isEqualTo(3)
    }

    @Test
    fun `partial on top left`() {
        val board = listOf(
            listOf("*", "*"),
            listOf("*", ".")
        )

        val count = Frame(board).countLiveNeighboursOf(1, 1)

        assertThat(count).isEqualTo(3)
    }

    @Test
    fun `rectangular matrix`() {
        val board = listOf(
            listOf("*", "*", "*"),
            listOf("*", "*", "*")
        )

        val count = Frame(board).countLiveNeighboursOf(0, 1)

        assertThat(count).isEqualTo(5)
    }

    @Test
    fun `do not count itself`() {
        val board = listOf(
            listOf("*", "*", "*"),
            listOf("*", "*", "*")
        )

        val count = Frame(board).countLiveNeighboursOf(0, 2)

        assertThat(count).isEqualTo(3)
    }
}