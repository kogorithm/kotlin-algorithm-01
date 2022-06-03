package `3week`.dongho

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    Array(N) {
        val (_, ext) = br.readLine().split(".")
        map.set(ext, map.getOrDefault(ext, 0) + 1)
    }
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    map.toSortedMap { o1, o2 -> o1.compareTo(o2) }.forEach { ext, count -> bw.write("$ext $count\n") }
    bw.flush()
    bw.close()
}
