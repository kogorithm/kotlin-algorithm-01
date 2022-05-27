import kotlin.math.abs

val size = readln().toInt()
val num = readln().split(" ").map { it.toInt() }
val visited1 = BooleanArray(num.size, { false })
val result = mutableListOf<Int>()
var ans2 = 0
fun main() {

    permutation(0, size)
    println(ans2)

}

// 순열로 모든 경우의 수 확인
fun permutation(cnt : Int, depth : Int) {
    if (cnt == depth) {
        // 이전 순열의 최대값(ans)보다 현재 순열의 최대값이 더 크다면 갱신
        if (getMax(result) > ans2) ans2 = getMax(result)
        return
    }
    for (i in 0 until num.size) {
        if (visited[i] == false) {
            visited[i] = true
            result.add(num[i])
            permutation(cnt + 1, depth)
            result.removeAt(result.lastIndex)
            visited[i] = false

        }
    }
}
// 수식을 계산
fun getMax(array: MutableList<Int>): Int {
    var ans = 0
    for (index in 2..array.size) {
        ans += abs(array[index - 2] - array[index - 1])
    }
    return ans
}