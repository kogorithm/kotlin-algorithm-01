package `4week`.jaewon

import java.util.*

class SK_2 {
    fun getSolution(): Solution {
        return Solution()
    }
    class Solution{
        fun solution(periods: IntArray, payments: Array<IntArray>, estimates: IntArray): IntArray {
            val answer = MutableList(2) { 0 }
            val isVIP = MutableList(payments.size - 1) { false }

            periods.zip(payments).forEachIndexed { index, pair ->
                if(loop(pair.first,pair.second.sum())){ isVIP.add(index, true) }
                val newSum = pair.second.drop(1).sum() + estimates[index]
                val loopValue = loop(pair.first+1,newSum)
                if (!loopValue && isVIP[index]){
                    answer[1]++
                }else if (loopValue && !isVIP[index]){
                    answer[0]++
                }
            }

            return answer.toIntArray()
        }
        fun loop(period: Int, newSum : Int) : Boolean{
            when (period) {
                in 0 until 24 -> {}
                in 24 until 60-> if (newSum >= 900000) { return true }
                else ->  if (newSum >= 600000) { return true }
            }
            return false
        }
    }

}

fun main() {
    val solution = SK_2().getSolution()
    println(
        Arrays.toString(solution.solution(intArrayOf(20, 23, 24), arrayOf(
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