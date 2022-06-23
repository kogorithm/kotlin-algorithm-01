package `6week`.seoyoon

fun main() {
    val T = readln().toInt()
    repeat(T) {
        val N = readln().toInt()
        val rank = Array(N, { IntArray(2) })
        var cnt = 1

        repeat(N) {
            rank[it] = readln().split(" ").map{ it.toInt() }.toIntArray()
        }
        var sorted = rank.sortedBy{ it.first() }

        var compare = sorted[0][1]
        repeat(N) {
            if (sorted[it][1] < compare) {
                cnt++
                compare = sorted[it][1]
            }
        }
        println(cnt)
    }
}