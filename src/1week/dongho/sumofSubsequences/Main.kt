package `1week`.dongho.sumofSubsequences

import java.io.*
import java.util.*

fun <T> List<T>.combination(num: Int): List<List<T>> {
    if (num == 1) {
        return map { listOf(it) }
    }
    val length = size
    val result = mutableListOf<List<T>>()
    for (i in 0 until length) {
        val current: T = this[i]
        val combinations = this.subList(i + 1, length).combination(num - 1)
        val attach = combinations.map { combination ->
            mutableListOf<T>(current).run {
                addAll(combination)
                this
            }
        }
        result.addAll(attach)
    }
    return result.toList()
}

fun String.parseIntPair(): Pair<Int, Int> {
    val (a, b) = split(" ")
    return Pair(a.toInt(), b.toInt())
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (N, S) = br.readLine().parseIntPair()
    val token = StringTokenizer(br.readLine())

    val list = IntRange(1, N).map {
        token.nextToken().toInt()
    }
    val answer = IntRange(1, N).fold(0) { prev, next ->
        prev + list.combination(next).filter { it.sum() == S }.count()
    }

    bw.write("$answer\n")
    bw.flush()
    bw.close()
}