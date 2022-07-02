package `7week`.seoyoon

import java.util.*

fun main() {
    val input = readln()
    var stack = Stack<Char>()
    var cnt = 0

    for (i in 0 until input.length) {
        if (input[i].equals('(')) {
            stack.push(input[i])
        }
        else {
            stack.pop()

            if (input[i-1].equals('(')) {
                cnt += stack.size
            }
            else {
                cnt += 1
            }
        }
    }
    println(cnt)
}
