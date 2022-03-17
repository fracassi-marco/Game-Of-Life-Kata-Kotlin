class BecomesLive : Rule {
    override fun isApplicable(liveNeighbours: Int) = liveNeighbours == 3
    override fun nextGen() = "*"
}

class Underpopulation : Rule {
    override fun isApplicable(liveNeighbours: Int) = liveNeighbours < 2
    override fun nextGen() = "."
}

class Overcrowding : Rule {
    override fun isApplicable(liveNeighbours: Int) = liveNeighbours > 3
    override fun nextGen() = "."
}

class None(private val cell: String) : Rule {
    override fun isApplicable(liveNeighbours: Int) = true
    override fun nextGen() = cell
}

interface Rule {
    fun isApplicable(liveNeighbours: Int): Boolean
    fun nextGen(): String
}
