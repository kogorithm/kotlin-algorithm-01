package `3week`.hyunsoo

fun main() {

    val frequencySort = mutableMapOf<Int, Int>()
    // 계수 정렬을 사용하기에는 C의 범위가 1,000,000,000 이하라서 무리...
    val (N, C) = readln().split(" ").map { it.toInt() }

    val sequence = readln().split(" ").map { it.toInt() }

    sequence.forEach {
        if (frequencySort.containsKey(it)) {
            frequencySort[it] = frequencySort[it]!! + 1
        } else frequencySort.put(it, 1)
    }

    frequencySort.toList().sortedByDescending { it.second }.toMap()
        .forEach { map ->
            repeat(map.value) {
                print("${map.key} ")
            }
        }

}