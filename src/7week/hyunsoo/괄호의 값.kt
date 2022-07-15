package `7week`.hyunsoo

import java.util.*

fun main() {

    val expression = readln().trim()

    val stack = Stack<Char>()
    var ans = 0
    var curValue = 0
    var curValueList = mutableListOf<Int>()

    var isInside = false
    for(index in expression.indices){

        var curChar = expression[index]

        if (curChar == '(' || curChar == '[') {
            stack.push(curChar)
            isInside = false

        } else if (curChar == ')') {

            if (stack.isNotEmpty()) {

                var lastStackChar = stack.peek()

                if (lastStackChar == '(') {
                    stack.pop()
                    if (isInside) {
                        curValue = curValueList[curValueList.lastIndex] * 2
                        curValueList[curValueList.lastIndex] = 0
                    } else {
                        curValue += 2
                        isInside = true
                    }
                } else stack.push(curChar)

            } else stack.push(curChar)

        } else if (curChar == ']') {

            if (stack.isNotEmpty()) {
                var lastStackChar = stack.peek()

                if (lastStackChar == '[') {
                    stack.pop()
                    if (isInside) {
                        curValue = curValueList[curValueList.lastIndex] * 3
                        curValueList[curValueList.lastIndex] = 0
                    } else {
                        curValue += 3
                        isInside = true
                    }
                } else stack.push(curChar)

            } else stack.push(curChar)
        } else {
            println(0)
            return
        }

        curValueList.add(curValue)
        if (stack.isEmpty()) {
            var sum = 0
            if (curChar == ')') {
                curValueList[curValueList.lastIndex] = curValueList[curValueList.lastIndex] / 2
                sum = curValueList.fold(0) { total, next -> total + next }
                ans += sum * 2
            } else {
                curValueList[curValueList.lastIndex] = curValueList[curValueList.lastIndex] / 3
                sum = curValueList.fold(0) { total, next -> total + next }
                ans += sum * 3
            }
            curValueList.clear()
        }
        curValue = 0
    }
    if (stack.isEmpty()) println(ans)
    else println(0)
}