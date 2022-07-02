package `7week`.seoyoon

import java.util.*

fun main() {
    val input = readln()
    var stack = Stack<Char>()
    var answer = 0
    var sum = 1

    for (i in 0 until input.length) {
        if (input[i] == '(') {
            stack.push(input[i])
            sum *= 2
        }

        else if (input[i] == '[') {
            stack.push(input[i])
            sum *= 3
        }

        else if (input[i] == ')') {
            if (input[i-1] == '(') {
                answer += sum
            }
            if (stack.isEmpty() || stack.peek() == '[') {
                answer = 0
                break
            }
            stack.pop()
            sum /= 2
        }

        else {
            if (input[i-1] == '[') {
                answer += sum
            }
            if (stack.isEmpty() || stack.peek() == '(') {
                answer = 0
                break
            }
            stack.pop()
            sum /= 3
        }
    }

    if (stack.isNotEmpty()) println(0)
    else println(answer)
}