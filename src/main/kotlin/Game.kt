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
                val liveNeighbours = Board(initialGenerationBoard).countNeighboursOf(i, j, "*")
                val cell = initialGenerationBoard[i][j]
                line.add(
                    listOf(BecomesLive(), Underpopulation(), Overcrowding(), None(cell)).first {
                        it.isApplicable(liveNeighbours)
                    }.nextGen()
                )
            }
        }

        return format(nextGenerationBoard)
    }

    private fun format(nextGenerationBoard: MutableList<List<String>>) =
        nextGenerationBoard.joinToString(separator = "\n") { it.joinToString("") }
}

