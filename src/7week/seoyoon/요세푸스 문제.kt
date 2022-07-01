package `7week`.seoyoon

import java.util.LinkedList

fun main() {
    // 3 6 2 7 5 1 4
    val (n, k) = readln().split(" ").map{ it.toInt() }
    var queue = LinkedList<Int>()
    var answer = LinkedList<Int>()

    (1 .. n).forEach {
        queue.add(it)
    }

    var idx = 1
    while (queue.isNotEmpty()) {
        if (idx == k) {
            answer.add(queue.poll())
            idx = 1
        }
        else {
            var tmp = queue.poll()
            queue.add(tmp)
            idx++
        }
    }

    print("<")
    for (i in 0 until answer.size-1) {
        print("${answer.poll()}, ")
    }
    print("${answer.poll()}>")
}
