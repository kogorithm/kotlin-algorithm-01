package `3week`.hyunsoo

import java.util.*

class `신고 결과 받기` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }
    class Solution {
        fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {

            // key는 신고한 아이디, value는 정지시킨 횟수
            val ansList = id_list.associateWith { 0 }.toMutableMap()

            // key는 신고한 사람, value는 신고당한 사람들
            val reportList = report.distinct()
                .map { it.split(" ") }.groupBy(
                    keySelector = {it[0]}, valueTransform = {it[1]}
                )

            // 모든 유저를 순차적으로 탐색하면서 신고받음을 확인함.
            ansList.forEach {

                val user = it.key
                // 신고받은 유저만 모으기.
                val whoReported = reportList.filter { it.value.contains(user) }

                if (whoReported.size >= k){
                    whoReported.forEach { report ->
                        ansList.put(report.key, ansList.getOrDefault(report.key, 0) + 1)
                    }

                }
            }

            return ansList.map { it.value }.toIntArray()
        }
    }
}

fun main() {
    val solution = `신고 결과 받기`.getSolution()
    println(Arrays.toString(solution.solution(arrayOf("muzi", "frodo", "apeach", "neo"), arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"), 2)))
    println(Arrays.toString(solution.solution(arrayOf("con", "ryan"), arrayOf("ryan con", "ryan con", "ryan con", "ryan con"), 3)))
}