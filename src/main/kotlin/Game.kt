class Game(private val initialGeneration: String) {
    fun nextGeneration(): String {
        val initialGenerationBoard = mutableListOf<List<String>>()
        initialGeneration.split("\n").forEach {
            val line = mutableListOf<String>()
            initialGenerationBoard.add(line)
            it.forEach { char -> line.add(char.toString()) }
        }

        val nextGenerationBoard = mutableListOf<List<String>>()
        for (i in 0 until initialGenerationBoard.size) {
            val line = mutableListOf<String>()
            nextGenerationBoard.add(line)
            for (j in 0 until initialGenerationBoard[i].size) {
                if (initialGenerationBoard[i][j] == "." && countNeighboursOf(initialGenerationBoard, i, j) == 3) {
                    line.add("*")
                } else {
                    line.add(initialGenerationBoard[i][j])
                }
            }
        }

        return nextGenerationBoard.joinToString(separator = "\n") { it.joinToString("") }
    }

    private fun countNeighboursOf(board: MutableList<List<String>>, row: Int, column: Int): Int {
        var count = 0
        try {
            if (board[row + 1][column] == "*") count++
        } catch (e: Exception) {
        }
        try {
            if (board[row + 1][column + 1] == "*") count++
        } catch (e: Exception) {
        }
        try {
            if (board[row][column + 1] == "*") count++
        } catch (e: Exception) {
        }
        try {
            if (board[row - 1][column] == "*") count++
        } catch (e: Exception) {
        }
        try {
            if (board[row - 1][column - 1] == "*") count++
        } catch (e: Exception) {
        }
        try {
            if (board[row - 1][column + 1] == "*") count++
        } catch (e: Exception) {
        }
        try {
            if (board[row + 1][column - 1] == "*") count++
        } catch (e: Exception) {
        }
        try {
            if (board[row][column - 1] == "*") count++
        } catch (e: Exception) {
        }

        return count
    }
}
