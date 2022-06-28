package `7week`.seoyoon

import java.util.*

fun main() {
    val input = readln()
    var stack = Stack<Char>()
    var cnt = 0

    input.forEach {
        if (it.equals('(')) {
            stack.push(it)
        }
        else if (it.equals(')')) {
            stack.pop()

            if ((it-1).equals('(')) {
                cnt += stack.size
            }
            else {
                cnt += 1
            }
        }
    }
    println(cnt)
}