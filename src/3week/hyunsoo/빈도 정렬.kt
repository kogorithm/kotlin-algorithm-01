package `3week`.hyunsoo

fun main() {

    val frequencySort = mutableMapOf<Int, Int>()
    
    // 계수 정렬을 사용하기에는 C의 범위가 1,000,000,000 이하라서 무리...
    val (N, C) = readln().split(" ").map { it.toInt() }

    val sequence = readln().split(" ").map { it.toInt() }

    sequence.forEach {

        frequencySort.put(it, frequencySort.getOrDefault(it, 0) + 1)
    }


    frequencySort.toList().sortedByDescending { it.second }.toMap()
        .forEach { map ->
            var ans =""
            repeat(map.value) {
                ans += "${map.key} "
            }
            print(ans)
        }
}