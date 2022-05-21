val n = readln().toInt()
val arr = readln().split(" ").map{it.toInt()}.toIntArray()
var newArr = IntArray(n)
var visited = BooleanArray(n, {false})
var max: Int = Int.MIN_VALUE

fun main() {
    permutation(0)
    println(max)
}

fun permutation(depth: Int) {
    if (depth == n) {
        var sum = 0;
        for (i in 0 until n-1) {
            sum += Math.abs(newArr[i] - newArr[i+1])
        }
        max = Math.max(max, sum)
    }

    for (i in 0 until n) {
        if (visited[i] == true) {
            continue
        }
        else {
            newArr[depth] = arr[i]
            visited[i] = true
            permutation(depth + 1)
            visited[i] = false
        }
    }
}