import kotlin.random.Random

fun main() {
    var initialGeneration = buildBoard(80, 30)

    repeat(100) {
        clearScreen()
        println(initialGeneration)
        initialGeneration = Game(initialGeneration).nextGeneration()
        Thread.sleep(1000)
    }
}

private fun buildBoard(columns: Int, rows: Int) = (1..rows).toList().joinToString("\n") {
    (1..columns).toList().joinToString("") { if (Random.nextBoolean()) "." else "*" }
}

private fun clearScreen() {
    println(System.lineSeparator().repeat(50))
}