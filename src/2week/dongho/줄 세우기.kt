package `2week`.dongho

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    bw.write("HelloWorld\n")
    bw.flush()
    bw.close()
}