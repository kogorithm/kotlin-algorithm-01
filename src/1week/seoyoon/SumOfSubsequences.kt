var ans:Int = 0

fun main() {
    val (n, s) = readln().split(" ").map{it.toInt()}
    val arr = readln().split(" ").map{it.toInt()}.toIntArray()

    subSum(n, s, arr,0, 0, 0)

    if (s == 0) {
        ans--
    }
    println(ans)
}

fun subSum(n: Int, s: Int, arr: IntArray, depth: Int, idx: Int, sum: Int) {
    if (depth == n) {
        if (sum == s) {
            ans++
        }
        return
    }

    subSum(n, s, arr, depth + 1, idx + 1, sum + arr[idx]);
    subSum(n, s, arr, depth + 1, idx + 1, sum);
}