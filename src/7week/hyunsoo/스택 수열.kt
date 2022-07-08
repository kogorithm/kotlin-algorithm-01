package `7week`.hyunsoo

import java.util.Stack

fun main() {

    val stack = Stack<Int>()
    val n = readln().toInt()

    val numList = mutableListOf<Int>()
    val operatorList = Stack<String>()

    for (no in 0 until n) {
        val num = readln().toInt()
        numList.add(num)
    }

    var curNum = 1
    var searchingIndex = 0
    while (curNum <= n) {
        stack.push(curNum++)
        operatorList.push("+")
        while (stack.peek() == numList[searchingIndex]) {
            operatorList.push("-")
            searchingIndex++
            stack.pop()
            if (stack.isEmpty()) break
        }

    }

    if (stack.isEmpty()) operatorList.forEach { println(it) }
    else println("NO")
}