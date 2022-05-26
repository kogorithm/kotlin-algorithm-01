package `2week`.seoyoon

import java.util.*

fun solution(n: Int, q: Int, arrA: IntArray, arrB: Array<IntArray>) {
    val sumArr = IntArray(n)
    arrA.sort()
    sumArr[0] = arrA[0]

    for (i in 1 until n) {
        sumArr[i] = sumArr[i - 1] + arrA[i]
    }

    for (i in 0 until q) {
        if (arrB[i][0] == 1 || arrB[i][1] == 1) {
            println(sumArr[arrB[i][1] - 1])
        }
        else {
            println(sumArr[arrB[i][1] - 1] - sumArr[arrB[i][0] - 1 - 1])
        }
    }
}

fun main() {
    val (n, q) = readln().split(" ").map{it.toInt()}
    val arrA = readln().split(" ").map { it.toInt() }.toIntArray()
    val arrB = Array(q, {IntArray(2)})

    for (i in 0 until q) {
        val st = StringTokenizer(readln())
        arrB[i][0] = Integer.parseInt(st.nextToken())
        arrB[i][1] = Integer.parseInt(st.nextToken())
    }

    solution(n, q, arrA, arrB)
}