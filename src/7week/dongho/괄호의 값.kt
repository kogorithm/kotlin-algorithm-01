package `7week`.dongho

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine()
    var flag = false
    var answer: Long = 0
    var value = 1
    val stack = Stack<Char>()
    for (i in 0 until string.length) {
        if (string[i] == '(') {
            stack.add(string[i])
            value *= 2
        }
        if (string[i] == '[') {
            stack.add(string[i])
            value *= 3
        }
        if (string[i] == ')') {
            if (stack.empty() || stack.peek() !== '(') {
                flag = true
                break
            }
            if (string[i - 1] == '(') {
                answer += value.toLong()
            }
            stack.pop()
            value /= 2
        } else if (string[i] == ']') {
            if (stack.empty() || stack.peek() !== '[') {
                flag = true
                break
            }
            if (string[i - 1] == '[') {
                answer += value.toLong()
            }
            stack.pop()
            value /= 3
        }
    }
    if (flag || !stack.empty()) {
        println(0)
    } else {
        println(answer)
    }
}