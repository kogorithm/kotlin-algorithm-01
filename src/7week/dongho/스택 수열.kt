package `7week`.dongho

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val queue = LinkedList<Int>()
    val answer = LinkedList<Char>()
    repeat(N) {
        queue.add(br.readLine().toInt())
    }
    val stack = Stack<Int>()
    repeat(N) {
        stack.push(it + 1)
        answer.add('+')
        while (queue.isNotEmpty() && stack.isNotEmpty() && stack.peek() == queue.peek()) {
            stack.pop()
            queue.poll()
            answer.add('-')
        }
    }
    if (stack.isNotEmpty()) {
        println("NO")
    } else {
        println(answer.joinToString("\n"))
    }
}