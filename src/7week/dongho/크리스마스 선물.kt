package `7week`.dongho

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer
    val N = br.readLine().toInt()
    val pq = PriorityQueue(Collections.reverseOrder<Int>())
    repeat(N) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        if (a == 0) {
            if (pq.isEmpty()) {
                println(-1)
            } else {
                println(pq.poll())
            }
        } else {
            repeat(a) {
                pq.offer(st.nextToken().toInt())
            }
        }
    }
}