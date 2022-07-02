package `7week`.seoyoon

import java.util.*

fun main() {
    var n = readln().toInt()
    var seq = IntArray(n)
    var stack = Stack<Int>()
    var answer = mutableListOf<Char>()
    var top = 0

    repeat(n) {
        seq[it] = readln().toInt()
    }

    for (i in 1 .. n) {
        stack.push(i)
        answer.add('+')

        while (stack.isNotEmpty() && stack.peek() == seq[top]) {
            stack.pop()
            answer.add('-')
            top++
        }
    }

    if (stack.isNotEmpty()) {
        println("NO")
    }
    else {
        println(answer.joinToString("\n"))
    }
}
