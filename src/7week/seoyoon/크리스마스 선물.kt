package `7week`.seoyoon

import java.util.*

fun main() {
    val n = readln().toInt()
    val queue = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(n) {
        val a = readln().trim().split(" ").map{ it.toInt() }
        if (a[0] == 0) {
            if (queue.isEmpty()) {
                println(-1)
            }
            else {
                println(queue.poll())
            }
        }
        else {
            for (i in 1 until a.size) {
                queue.add(it)
            }
        }
    }
}