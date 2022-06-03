package `3week`.dongho

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c) = br.readLine().split(" ").map { it.toInt() }

    val set = mutableSetOf<String>()
    var answer = 0

    val strArr = Array(r) { br.readLine() }
    val columns = Array(c) { i ->
        val sb = StringBuffer()
        repeat(r - 1) { j ->
            sb.append(strArr[j + 1][i])
        }
        sb.toString()
    }

    repeat(r) { i ->
        set.clear()
        repeat(c) { j ->
            val str = columns[j].substring(i)
            if (set.contains(str)) {
                println(answer)
                return
            } else {
                set.add(str)
            }
        }
        answer++
    }
}
