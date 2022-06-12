package `4week`.dongho

import java.util.Arrays

class First {
    fun getSolution(): Solution {
        return Solution()
    }

    class Solution {

        fun solution(p: IntArray): IntArray {
            val length = p.size
            val answer = p.map {
                0
            }.toMutableList()
            var min: Int
            for (i in 0 until length - 1) {
                min = i
                for (j in i + 1 until length) {
                    if (p[min] > p[j]) {
                        min = j
                    }
                }
                if (min != i) {
                    answer[min]++
                    answer[i]++
                    val temp = p[i]
                    p[i] = p[min]
                    p[min] = temp
                }
            }

            return answer.toIntArray()
        }
    }
}

fun main() {
    val solution = First().getSolution()
    println(Arrays.toString(solution.solution(intArrayOf(2, 5, 3, 1, 4))))
}