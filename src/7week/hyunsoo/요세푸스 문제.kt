package `7week`.hyunsoo

import java.util.Stack

fun main() {

    val (n, k) = readln().split(" ").map { it.toInt() }
    val numList = (1..n).toMutableList()
    val ansList = mutableListOf<Int>()

    var index = (k - 1)
    while (numList.isNotEmpty()) {

        index %= numList.size
        ansList.add(numList[index])
        numList.removeAt(index)
        index += k - 1

    }

    val ans = ansList.joinToString(", ")
    print("<$ans>")
}