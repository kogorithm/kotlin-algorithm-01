package `6week`.dongho

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, L) = br.readLine().split(" ").map { it.toInt() }

    val pipe = TreeSet(br.readLine().split(" ").map { it.toInt() }).toList()

    var count = 1
    var i = 0
    for (j in 1 until N) {
        if (pipe[i] + L - 1 < pipe[j]) {
            count++
            i = j
        }
    }

    println(count)
}