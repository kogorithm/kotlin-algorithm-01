package `3week`.seoyoon

import java.util.*
import kotlin.collections.LinkedHashMap

fun main() {
    val (n, c) = readln().split(" ").map{ it.toInt() }

    // LinkedHashMap :: 입력된 순서대로 Key 보장
    val map = LinkedHashMap<Int, Int>()
    val st = StringTokenizer(readLine(), " ")

    repeat(n) {
        val num = st.nextToken().toInt()
        map.put(num, map.getOrDefault(num, 0) + 1)
    }

    // map의 keySet을 list에 저장
    val list = map.keys.map{it}
    val sortedList = list.sortedByDescending { map[it] }

    for (i in sortedList) {
        for (key in map.keys) {
            if (i == key) {
                repeat(map[key]!!) {
                    print("$key ")
                }
            }
        }
    }
}