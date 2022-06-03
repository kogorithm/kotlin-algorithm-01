package `3week`.hyunsoo

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val stringList = mutableListOf<String>()
    val stringSet = mutableSetOf<String>()

    var result = 0
    val (row, col) = br.readLine().split(" ").map { it.toInt() }

    repeat(row) {
        val string = br.readLine()
        stringList.add(string)
    }

    // start, end 는 row의 인덱스임
    var start = 0
    var end = row - 1

    var isOverlap = false

    while (start <= end) {

        val mid = (start + end) / 2

        for (colIndex in 0 until col) {

            var newString = ""

            for (rowIndex in mid until row) {
                newString += stringList[rowIndex][colIndex]
            }

            // 중복된 값있는지 찾기
            if (stringSet.add(newString) == false) {
                isOverlap = true
                break
            }
        }

        // 중복된 값이 있으면
        if (isOverlap) {
            end = mid - 1
            // 중복된 값이 없으면
        } else {
            result = mid
            start = mid + 1
        }

        isOverlap = false

    }
    bw.write("$result")
    bw.flush()
    bw.close()

}