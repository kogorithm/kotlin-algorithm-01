package `2week`.hyunsoo

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 누적 합.
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, Q) = br.readLine().split(" ").map { it.toInt() }
    var arrayB = br.readLine().split(" ").map { it.toInt() }.toIntArray().sortedArray()
    var sumOfB = IntArray(arrayB.size + 1, { 0 }) // 인덱스 계산을 편하게 하기 위해.

    // 정렬 후 누적 합 계산. ex) sumOfB[3]은 arrayB[0] ~ arrayB[2]의 합이 담기게 됨.
    arrayB.forEachIndexed { index, it ->
        sumOfB[index + 1] = sumOfB[index] + it

    }

    repeat(Q) {
        val range = br.readLine().split(" ").map { it.toInt() }
        var ans = sumOfB[range[1]] - sumOfB[range[0] - 1]

        bw.write("$ans\n")

    }
    bw.flush()
    bw.close()

}