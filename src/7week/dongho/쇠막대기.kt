package `7week`.dongho

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stack: Stack<Int> = Stack()
    var i = 1
    println(br.readLine().sumOf {
        val result = if (it == '(') {
            stack.push(i)
            0
        } else {
            if (i - 1 == stack.peek()) {
                stack.pop()
                stack.size
            } else {
                stack.pop()
                1
            }
        }
        i++
        result
    })
}