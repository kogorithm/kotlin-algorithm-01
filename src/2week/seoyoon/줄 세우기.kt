package `2week`.seoyoon

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map{it.toInt()}
    var degree = IntArray(n+1)

    val graph : Array<ArrayList<Int>> = Array(n+1){ ArrayList() }
    for (i in 1..n) {
        graph[i] = ArrayList()
    }

    for (i in 1 .. m) {
        val (A, B) = readln().split(" ").map{it.toInt()}

        graph[A].add(B)
        degree[B]++
    }

    val queue: Queue<Int> = LinkedList()
    val result: Queue<Int> = LinkedList()

    for (i in 1..n) {
        if (degree[i] == 0) {
            queue.offer(i)
        }
    }

    while (!queue.isEmpty()) {
        val node = queue.poll()
        result.offer(node)

        for (i in graph[node]) {
            degree[i]--

            if (degree[i] == 0) {
                queue.offer(i)
            }
        }
    }

    for (i in result) {
        print("$i ")
    }
}