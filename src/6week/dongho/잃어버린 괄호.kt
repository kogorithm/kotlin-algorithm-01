package `6week`.dongho

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val answer = br.readLine().split("-").toMutableList().run {
        removeFirst().split("+").sumOf { it.toInt() } - sumOf { it.split("+").sumOf { it.toInt() } }
    }
    println(answer)
}