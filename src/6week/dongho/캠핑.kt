package `6week`.dongho

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val result = mutableListOf<Int>()
    while (true) {
        val (L, P, V) = br.readLine().split(" ").map { it.toInt() }
        if (L == 0 && P == 0 && V == 0) {
            break
        }
        result.add((V / P) * L + (V % P).coerceAtMost(L))
    }
    println(result.mapIndexed { index, value -> "Case ${index + 1}: $value" }.joinToString("\n"))
}