package `2week`.dongho

import java.io.*
import java.util.*

// 이쪽 풀이 참고하시면 좋을것 같아요 설명 잘되어있음!
// https://blog.naver.com/PostView.nhn?blogId=sweetgirl0111&logNo=222227941751&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val indegree = IntArray(N + 1)
    val graph: MutableList<MutableList<Int>> = ArrayList()
    for (i in 0 until N + 1) {
        graph.add(ArrayList())
    }
    for (i in 0 until M) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        indegree[b]++
    }

    val q: Queue<Int> = LinkedList()
    val result: Queue<Int> = LinkedList()
    for (i in 1 until indegree.size) {
        if (indegree[i] == 0) {
            q.offer(i)
        }
    }

    var current: Int
    while (q.isNotEmpty()) {
        current = q.poll()
        result.offer(current)
        for (i in graph[current]) {
            indegree[i]--
            if (indegree[i] == 0) {
                q.offer(i)
            }
        }
    }

    println(result.joinToString(" "))
}