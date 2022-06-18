package `6week`.hyunsoo

fun main() {

    var (n, k) = readln().split(" ").map { it.toInt() }

    val coinList = mutableListOf<Int>()
    var ans = 0
    repeat(n) {
        coinList.add(readln().toInt())
    }

    // 내림차순 정렬
    coinList.sortedByDescending { it }.forEach {
        // 코인이 나누어 진다면 해당 코인만큼 계산해줌.
        val coinCnt = k / it
        if (coinCnt > 0) {
            ans += coinCnt
            k -= coinCnt * it
        }
    }
    println(ans)
}