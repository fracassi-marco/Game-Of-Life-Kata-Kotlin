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
                val countLiveNeighboursOf = Board(initialGenerationBoard).countNeighboursOf(i, j, "*")
                if (initialGenerationBoard[i][j] == "." && countLiveNeighboursOf == 3) {
                    line.add("*")
                } else if (initialGenerationBoard[i][j] == "*" && countLiveNeighboursOf == 1) {
                    line.add(".")
                } else {
                    line.add(initialGenerationBoard[i][j])
                }
            }
        }

        return format(nextGenerationBoard)
    }

    private fun format(nextGenerationBoard: MutableList<List<String>>) =
        nextGenerationBoard.joinToString(separator = "\n") { it.joinToString("") }
}

