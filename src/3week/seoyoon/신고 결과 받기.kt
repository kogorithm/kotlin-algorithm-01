package `3week`.seoyoon

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

            // 각 유저별 신고당한 횟수 저장
            val reportMap = hashMapOf<String, Int>()
            report.distinct().forEach {
                val badUser = it.split(" ")[1]
                reportMap.put(badUser, reportMap.getOrDefault(badUser, 0) + 1)
            }

            // 각 신고자 별 처리 결과 메일을 받는 횟수
            report.distinct().forEach {
                val reporter = it.split(" ")[0]
                val badUser = it.split(" ")[1]
                if (reportMap[badUser]!! >= k) {
                    answerMap[reporter] = answerMap.getOrDefault(reporter, 0) + 1
                }
            }
            return answerMap.values.toIntArray()
        }
    }
}

fun main() {
    val solution = `신고 결과 받기`.getSolution()
    println(Arrays.toString(solution.solution(
        arrayOf("muzi", "frodo", "apeach", "neo"),
        arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"),
        2)))

    println(Arrays.toString(solution.solution(
        arrayOf("con", "ryan"),
        arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
        3)))
}