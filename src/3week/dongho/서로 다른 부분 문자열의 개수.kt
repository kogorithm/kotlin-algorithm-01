package `3week`.dongho

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val set = mutableSetOf<String>()
    val length = str.length
    Array(length) { i ->
        IntRange(i + 1, length).forEach { j ->
            set.add(str.substring(i until j))
        }
    }
    println(set.size)
}
