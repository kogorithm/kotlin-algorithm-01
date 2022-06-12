package `4week`.dongho

import java.util.Arrays

class Second {
    fun getSolution(): Solution {
        return Solution()
    }

    class Solution {
        fun vipCheck(period: Int, totalPayments: Int): Boolean = when {
            period >= 60 && totalPayments >= 600000 -> true
            period >= 24 && totalPayments >= 900000 -> true
            else -> false
        }

        fun solution(periods: IntArray, payments: Array<IntArray>, estimates: IntArray): IntArray {
            val answer = intArrayOf(0, 0)
            periods.forEachIndexed { i, period ->
                val userPayments = payments.get(i)
                val totalPayments = userPayments.sum()
                val firstMonth = userPayments.first()
                val nextPayments = totalPayments - firstMonth + estimates.get(i)
                val currentVip = vipCheck(period, totalPayments)
                val nextVip = vipCheck(period + 1, nextPayments)
                if (!currentVip && nextVip) {
                    answer[0]++
                }
                if (currentVip && !nextVip) {
                    answer[1]++
                }
            }

            return answer
        }
    }
}

fun main() {
    val solution = Second().getSolution()
    println(Arrays.toString(solution.solution(intArrayOf(20, 23, 24), arrayOf(
        intArrayOf(100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000),
        intArrayOf(100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000),
        intArrayOf(350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000)
    ), intArrayOf(100000, 100000, 100000))))
    println(Arrays.toString(solution.solution(intArrayOf(24, 59, 59, 60), arrayOf(
        intArrayOf(50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000),
        intArrayOf(50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000),
        intArrayOf(350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000),
        intArrayOf(50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000)
    ), intArrayOf(350000, 50000, 40000, 50000))))
}