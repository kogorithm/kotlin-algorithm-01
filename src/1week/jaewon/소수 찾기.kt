package `1week`.jaewon

import java.io.BufferedReader
import java.io.InputStreamReader

var result = 0
val tempSet = mutableSetOf<Int>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().map { "$it".toInt() }

    for (i in 1 until n.size + 1) {
        val answer = mutableListOf<List<Int>>()
        combination(answer, n, Array<Boolean>(n.size + 1) { false }, 0, i)
        answer.distinct().forEach {
            makeNumber(permutation(it).distinct())
        }
    }

    tempSet.forEach { if(isPrime(it))result++ }
    print(result)
}

fun makeNumber(list: List<List<Int>>) {
    var number =""
    list.forEach {
        it.forEach { int ->
            number = "${number}${int}"
        }
        tempSet.add(number.toInt())
        number = ""
    }
}

fun isPrime(n : Int): Boolean {
    if(n <= 1) return false
    return (2..Math.sqrt(n.toDouble()).toInt()).none{ n % it == 0 }
}
