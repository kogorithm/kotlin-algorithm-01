package `5week`.dongho

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nodeCnt = br.readLine().toInt()
    val N = br.readLine().toInt()

    val infectionChecker = BooleanArray(nodeCnt)
    infectionChecker[0] = true

    val deque: Deque<Pair<Int, Int>> = LinkedList()
    var p: Pair<Int, Int>
    for (i in 0 until N) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        p = Pair(a, b)
        if (a == 1 || b == 1) {
            deque.addFirst(p)
        } else {
            deque.addLast(p)
        }
    }

    var answer = 0
    var afterCnt = 0
    var update = false

    while (!deque.isEmpty()) {
        if (afterCnt == deque.size) {
            if (update) {
                afterCnt = 0
                update = false
            } else {
                break
            }
        }
        
        p = deque.pollFirst()
        val a = p.first - 1
        val b = p.second - 1
        if (infectionChecker[a] || infectionChecker[b]) {
            if (!(infectionChecker[a] && infectionChecker[b])) {
                infectionChecker[a] = true
                infectionChecker[b] = true
                answer++
                update = true
            }
        } else {
            afterCnt++
            deque.addLast(p)
        }
    }
    
    println(answer)
}