package `9week`.dongho

class Second {
    fun getSolution(): Solution {
        return Solution()
    }

    class Solution {
        companion object {
            val USER_1 = IntRange(1, 5).toList()
            val USER_2 = listOf(2, 1, 2, 3, 2, 4, 2, 5)
            val USER_3 = listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        }

        fun solution(answers: IntArray): IntArray {
            fun checker(user: List<Int>): Int {
                val userSize = user.size
                return answers.mapIndexed { i, answer ->
                    val userI = i % userSize
                    if (user[userI] == answer) 1 else 0
                }.sum()
            }
            var maxScore = 0
            val result = IntRange(1, 3).map { num ->
                val score = checker(
                    when (num) {
                        1 -> USER_1
                        2 -> USER_2
                        3 -> USER_3
                        else -> listOf()
                    }
                )
                if (maxScore < score) {
                    maxScore = score
                }
                Pair(num, score)
            }
            return result.filter { maxScore == it.second }.map { it.first }.toIntArray()
        }
    }
}

fun main() {
    val solution = Second().getSolution()
    println(solution.solution(intArrayOf(1,2,3,4,5)).contentToString())
    println(solution.solution(intArrayOf(1,3,2,4,2)).contentToString())
}