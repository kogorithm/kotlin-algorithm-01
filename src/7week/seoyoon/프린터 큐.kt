package `7week`.seoyoon

import java.util.*

fun main() {
    val t = readln().toInt()
    var queue : Queue<Pair<Int, Int>>
    var sortedOrder : Queue<Int>

    repeat(t) {
        val (n, m) = readln().split(" ").map{ it.toInt() }
        val value = readln().split(" ").map{ it.toInt() }
        var cnt = 1

        sortedOrder = LinkedList(value.sortedDescending())
        queue = LinkedList()
        value.forEachIndexed { index, it ->
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