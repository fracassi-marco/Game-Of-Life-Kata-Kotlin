class Game(private val initialGeneration: String) {
    fun nextGeneration(): String {
        val initialGenerationBoard = parse()

        val nextGenerationBoard = buildNextGeneration(initialGenerationBoard)

        return format(nextGenerationBoard)
    }

    private fun buildNextGeneration(initialGenerationBoard: List<List<String>>) =
        initialGenerationBoard.mapIndexed { i, row ->
            row.mapIndexed { j, cell ->
                val liveNeighbours = Frame(initialGenerationBoard).countLiveNeighboursOf(i, j)
                listOf(BecomesLive(), Underpopulation(), Overcrowding(), None(cell)).first {
                    it.isApplicable(liveNeighbours)
                }.nextGen()
            }
        }

    private fun parse() = initialGeneration.split("\n").map {
        it.map { char -> char.toString() }
    }

    private fun format(nextGenerationBoard: List<List<String>>) =
        nextGenerationBoard.joinToString("\n") { it.joinToString("") }
}

