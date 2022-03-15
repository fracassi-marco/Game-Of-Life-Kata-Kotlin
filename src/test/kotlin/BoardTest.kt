import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BoardTest {

    @Test
    fun full() {
        val board = listOf(
            listOf("*", "*", "*"),
            listOf("*", ".", "*"),
            listOf("*", "*", "*"),
        )

        val count = Board(board).countNeighboursOf(1, 1, "*")

        assertThat(count).isEqualTo(8)
    }

    @Test
    fun `partial on bottom right`() {
        val board = listOf(
            listOf(".", "*"),
            listOf("*", "*")
        )

        val count = Board(board).countNeighboursOf(0, 0, "*")

        assertThat(count).isEqualTo(3)
    }

    @Test
    fun `partial on top left`() {
        val board = listOf(
            listOf("*", "*"),
            listOf("*", ".")
        )

        val count = Board(board).countNeighboursOf(1, 1, "*")

        assertThat(count).isEqualTo(3)
    }

    @Test
    fun `any char`() {
        val board = listOf(
            listOf(".", "X"),
            listOf("X", "X")
        )

        val count = Board(board).countNeighboursOf(0, 0, "X")

        assertThat(count).isEqualTo(3)
    }

    @Test
    fun `rectangular matrix`() {
        val board = listOf(
            listOf("*", "*", "*"),
            listOf("*", "*", "*")
        )

        val count = Board(board).countNeighboursOf(0, 1, "*")

        assertThat(count).isEqualTo(5)
    }

    @Test
    fun `do not count itself`() {
        val board = listOf(
            listOf("*", "*", "*"),
            listOf("*", "*", "*")
        )

        val count = Board(board).countNeighboursOf(0, 2, "*")

        assertThat(count).isEqualTo(3)
    }
}