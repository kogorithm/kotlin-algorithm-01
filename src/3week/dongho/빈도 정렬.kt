package `3week`.dongho

import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 키에 맞는 빈도렁
    val counter = mutableMapOf<Int, Int>()
    // 최소 인덱스
    val indexes = mutableMapOf<Int, Int>()
    br.readLine()
    val list = br.readLine().split(" ").mapIndexed { index, s ->
        val key = s.toInt()
        counter.set(key, counter.getOrDefault(key, 0) + 1)
        indexes.set(key, min(indexes.getOrDefault(key, Int.MAX_VALUE), index))
        key
    }
    println(list.sortedWith { a, b ->
        // thenBy 쓰고 싶다
        val aSize = counter.get(a)!!
        val bSize = counter.get(b)!!
        val diff = bSize - aSize
        if (diff == 0) {
            // 갯수 같을때는 인덱스 비교
            indexes.get(a)!! - indexes.get(b)!!
        } else {
            diff
        }
    }.joinToString(" "))
}
