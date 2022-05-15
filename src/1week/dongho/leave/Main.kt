package `1week`.dongho.leave

import java.io.*

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

fun List<Triple<Int, Int, Int>>.avaiableMax(maxDate: Int): Int? {
    var totalPrice = 0
    this.fold(0) { prev, (day, range, price) ->
        if (prev >= day || (day + range - 1) > maxDate) {
            return null
        }
        totalPrice += price
        day + range - 1
    }
    return totalPrice
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val tripleList = IntRange(1, N).map {
        val (range, price) = br.readLine().parseIntPair()
        Triple(it, range, price)
    }

    val answer = IntRange(1, N).maxOf {
        tripleList.combination(it).fold<List<Triple<Int, Int, Int>>, MutableList<Int>>(mutableListOf()) { prev, next ->
            val result = next.avaiableMax(N)
            if (result != null) {
                prev.add(result)
            }
            prev
        }.maxOfOrNull { it }?: 0
    }
    bw.write("$answer\n")
    bw.flush()
    bw.close()
}