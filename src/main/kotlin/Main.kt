import java.lang.System.lineSeparator
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

private fun buildBoard(columns: Int, rows: Int) = (1..rows).joinToString("\n") {
    (1..columns).joinToString("") { if (Random.nextBoolean()) "." else "*" }
}

private fun clearScreen() {
    println(lineSeparator().repeat(50))
}