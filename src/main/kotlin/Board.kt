class Board(private val board: List<List<String>>) {
    fun countNeighboursOf(row: Int, column: Int, char: String): Int {
        var count = 0
        for (i in -1..+1)
            for (j in -1..+1) {
                if(i == 0 && j == 0)
                    continue
                try {
                    if (board[row + i][column + j] == char) count++
                } catch (e: Exception) {
                }
            }
        return count
    }
}