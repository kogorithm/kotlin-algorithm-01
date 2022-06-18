package `5week`.dongho

import java.io.*
import kotlin.properties.Delegates

var answer = -1

var finish by Delegates.notNull<Int>()
lateinit var graph: Array<MutableList<Int>>
lateinit var visited: BooleanArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    visited = BooleanArray(n + 1) { false }
    graph = Array(n + 1) {
        mutableListOf<Int>()
    }
    val (start, end) = br.readLine().split(" ").map { it.toInt() }
    finish = end

    val m = br.readLine().toInt()
    repeat(m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        graph.get(x).add(y)
        graph.get(y).add(x)
    }

    dfs(start, 0);
    println(answer);
}

private fun dfs(point: Int, cnt: Int) {
    visited[point] = true
    for (x in graph[point]) {
        if (!visited[x]) {
            if (x == finish) {
                answer = cnt + 1
                return
            }
            dfs(x, cnt + 1)
        }
    }
}