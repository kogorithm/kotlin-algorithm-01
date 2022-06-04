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
    // map의 value값을 기준으로 list에 저장된 keySet을 내림차순 정렬
    val sortedList = list.sortedByDescending { map[it] }

    for (i in sortedList) {
        for (key in map.keys) {
            // list의 요소인 key와 일치하는 key를 map에서 찾으면
            if (i == key) {
                // map의 value값 만큼 반복해서 출력
                repeat(map[key]!!) {
                    print("$key ")
                }
            }
        }
    }
}