package `3week`.dongho

import java.util.*

class `신고 결과 받기` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
            val answerMap = id_list.associate { it to 0 }.toMutableMap()
            val reportPairList = report.toSet().map {
                val list = it.split(" ")
                list.last() to list.first()
            }.groupBy({ it.first }, { it.second })
            reportPairList.forEach { to, fromList ->
                if (fromList.size >= k) {
                    fromList.forEach { from ->
                        answerMap.set(from, answerMap.getOrDefault(from, 0) + 1)
                    }
                }
            }
            return answerMap.map { it.value }.toIntArray()
        }
    }
}

fun main() {
    val solution = `신고 결과 받기`.getSolution()
    println(Arrays.toString(solution.solution(arrayOf("muzi", "frodo", "apeach", "neo"), arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"), 2)))
    println(Arrays.toString(solution.solution(arrayOf("con", "ryan"), arrayOf("ryan con", "ryan con", "ryan con", "ryan con"), 3)))
}