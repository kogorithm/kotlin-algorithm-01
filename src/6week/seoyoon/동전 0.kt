package `6week`.seoyoon

fun main() {
    var (N, K) = readln().split(" ").map{ it.toInt() }
    val coin = IntArray(N) { readln().toInt() }
    var cnt = 0

    for (i in N - 1 downTo 0) {
        cnt += K / coin[i]
        K = K % coin[i]
    }
    println(cnt)
}