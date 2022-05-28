package `2week`.jaewon

class `겹치지 않는 간격` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun solution(intervals: Array<IntArray>): Int {
            intervals.sortBy { it[1] }
            var result = 1
            var firstTemp = intervals.first()[1]
            for(i in 1 until intervals.size){
                val (start,end) = intervals[i]
                if(firstTemp <= start){
                    firstTemp = end
                    result++
                }
            }
            return intervals.size - result
        }
    }
}

fun main(){
    val solution = `겹치지 않는 간격`.getSolution()
    println(solution.solution(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(1,3))))

}