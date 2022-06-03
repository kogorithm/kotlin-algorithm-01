package `3week`.seoyoon

import java.util.TreeMap

fun main() {
    val n = readln().toInt()
    val map = hashMapOf<String, Int>()

    repeat(n) {
        val file = readln()
        val idx = file.indexOf(".") + 1
        map.put(file.substring(idx), map.getOrDefault(file.substring(idx), 0) + 1)
    }

    // Key 기준 사전순 정렬을 위해 TreeMap 사용
    // TreeMap :: 키를 저장함과 동시에 자동 오름차순으로 정렬. 레드 블랙 트리로 이루어짐
    val sortedMap = TreeMap(map)
    sortedMap.forEach { println("${it.key} ${it.value}") }
}