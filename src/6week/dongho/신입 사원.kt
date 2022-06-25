package `6week`.dongho

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    println(Array(T) {
        val N = br.readLine().toInt()
        PriorityQueue<Pair<Int, Int>> { a, b -> a.first - b.first }.apply {
            addAll(Array(N) {
                val (x, y) = br.readLine().split(" ").map { it.toInt() }
                Pair(x, y)
            })
        }.run {
            var answer = 1
            var minInterview = poll().second
            for (i in 1 until N) {
                val valueInterview = poll()
                valueInterview.run {
                    if (second < minInterview) {
                        answer++
                        minInterview = second
                    }
                }
            }
            answer
        }
    }.joinToString("\n"))
}