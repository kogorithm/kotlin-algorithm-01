package `1week`.dongho

import java.io.*
import java.util.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M, B) = br.readLine().split(" ").map { it.toInt() }
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    var tokenizer: StringTokenizer
    val map = IntRange(0, N - 1).map { i ->
        tokenizer = StringTokenizer(br.readLine())
        IntRange(0, M - 1).map { j ->
            val value = tokenizer.nextToken().toInt()
            max = max(value, max)
            min = min(value, min)
            value
        }
    }

    var answerSecond = Int.MAX_VALUE
    var answerFloor = -1
    for (i in min..max) {
        var seconds = 0
        var blocks = B
        for (j in 0 until map.size) {
            for (k in 0 until map.get(j).size) {
                val diff: Int = map.get(j).get(k) - i
                if (diff > 0) {
                    seconds += Math.abs(diff) * 2
                    blocks += Math.abs(diff)
                } else if (diff < 0) {
                    seconds += Math.abs(diff)
                    blocks -= Math.abs(diff)
                }
            }
        }
        if (blocks >= 0 && seconds <= answerSecond) {
            answerSecond = seconds
            answerFloor = i
        }
    }

    println("$answerSecond $answerFloor")
}