package `7week`.dongho

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val queue: Queue<Int> = LinkedList(IntRange(1, N).toList())
    var i = 1
    val answer = LinkedList<Int>()
    while (queue.isNotEmpty()) {
        val temp = queue.poll()
        if (i == K) {
            i = 1
            answer.add(temp)
        } else {
            queue.add(temp)
            i++
        }
    }
    println("<${answer.joinToString(", ")}>")
}