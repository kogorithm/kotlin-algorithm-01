package `2week`.seoyoon

fun solution(n: Int, arr: IntArray): Int {
    var ans = 0
    arr.sort()

    for (i in 0 until n) {
        for (j in 0..i) {
            ans += arr[j]
        }
    }
    return ans
}

fun main() {
    val n = Integer.parseInt(readln())
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    println(solution(n, arr))
}

