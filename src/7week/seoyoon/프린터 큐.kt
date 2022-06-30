package `7week`.seoyoon

import java.util.*

fun main() {
    val t = readln().toInt()
    var queue : Queue<Pair<Int, Int>>
    var sortedOrder : Queue<Int>
    // 1 1 9 1 1 1
    // 5 6 1 2 3 4
    repeat(t) {
        val (n, m) = readln().split(" ").map{ it.toInt() }
        // 1 1 9 1 1 1
        val value = readln().split(" ").map{ it.toInt() }
        var cnt = 1

        // 9 1 1 1 1 1
        sortedOrder = LinkedList(value.sortedDescending())
        queue = LinkedList()
        value.forEachIndexed { index, it ->
            // 0 1 2 3 4 5
            // 1 1 9 1 1 1
            queue.add(Pair(index, it))
        }

        while (sortedOrder.isNotEmpty()) {
            if (queue.peek().second != sortedOrder.peek()) {
                var tmp = queue.poll()
                queue.add(tmp)
            }
            else {
                if (queue.peek().first == m) {
                    println(cnt)
                    break
                }
                queue.poll()
                sortedOrder.poll()
                cnt++
            }
        }
    }
}