import java.lang.Math.max

fun main() {
    val n = readln().toInt()
    val T = IntArray(n + 1)
    val P = IntArray(n + 1)
    val arr = IntArray(n + 2)

    for (i in 1..n) {
        val input = readln().split(" ").map { it.toInt() }
        T[i] = input[0]
        P[i] = input[1]
    }

    for (i in 1..n) {
        if (i + T[i] <= n + 1) {
            arr[i + T[i]] = max(arr[i + T[i]], arr[i] + P[i])
        }
        arr[i + 1] = max(arr[i + 1], arr[i])
    }
    println(arr[n + 1])
}
