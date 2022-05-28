package `2week`.dongho

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (_, Q) = br.readLine().split(" ").map { it.toInt() }
    val B = br.readLine().split(" ").map { it.toInt() }.sorted()
    val Bsum = B.fold(mutableListOf(0)) { prev, next ->
        prev.add((prev.lastOrNull() ?: 0) + next)
        prev
    }
    repeat(Q) {
        val (L, R) = br.readLine().split(" ").map { it.toInt() }
        bw.write("${Bsum.get(R) - Bsum.get(L - 1)}\n")
    }
    bw.flush()
    bw.close()
}