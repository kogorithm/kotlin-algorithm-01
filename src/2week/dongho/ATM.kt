package `2week`.dongho

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val pq = PriorityQueue(br.readLine().split(" ").map { it.toInt() }.toList())
    var temp = 0
    var answer = 0
    while (!pq.isEmpty()) {
        temp += pq.poll()
        answer += temp
    }
    println(answer)
}