package `1week`.dongho.maxTheDifference

import java.io.*
import java.util.*
import kotlin.math.*

fun <T> List<T>.permutation(num: Int): List<List<T>> {
    if (num == 1) {
        return map { v: T ->
            listOf(v)
        }
    }
    val result = mutableListOf<List<T>>()
    val length = size
    for (i in 0 until length) {
        val current: T = this[i]
        val permutations = mutableListOf<T>().let {
            it.addAll(this.subList(0, i))
            it.addAll(this.subList(i + 1, length))
            it
        }.permutation(num - 1)
        val attach = permutations.map { permutation ->
            mutableListOf(current).run {
                addAll(permutation)
                this
            }
        }
        result.addAll(attach)
    }
    return result.toList()
}

fun List<Int>.assignDiff(): Int = IntRange(1, size - 1).sumOf {
    abs(this[it - 1] - this[it])
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()

    val st = StringTokenizer(br.readLine())
    val list = IntRange(1, N).map { st.nextToken().toInt() }

    val answer = list.permutation(N).maxOf { it.assignDiff() }
    bw.write("$answer\n")

    bw.flush()
    bw.close()
}