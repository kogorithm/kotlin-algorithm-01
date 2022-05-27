package `2week`.hyunsoo

import java.util.LinkedList
import java.util.Queue

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }

    var indegree = IntArray(N + 1, { 0 })
    val graph = Array<MutableList<Int>>(N + 1, { mutableListOf() })
    val result = mutableListOf<Int>()
    var queue: Queue<Int> = LinkedList<Int>()

    repeat(M) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        indegree[b] += 1
    }

    for (i in 1..N) {
        if (indegree[i] == 0)
            queue.add(i)
    }

    while (queue.isNotEmpty()) {

        val cur = queue.poll()
        result.add(cur)
        for (index in graph[cur]) {
            indegree[index] -= 1
            if (indegree[index] == 0)
                queue.add(index)
        }
    }

    result.forEach {
        print("$it ")
    }

}
