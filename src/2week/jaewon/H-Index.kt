package `2week`.jaewon


class `H-index` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun solution(citations: IntArray): Int {
            var answer = 0
            citations.sortedDescending().forEachIndexed{ index, num ->
                if( index+1 <= num ){ // 인용된 논문의 횟수보다 인용되지 않은 논문의 횟수가 더 많아지는 지점
                    answer = index+1 // [0]6,[1]5,[2]3,[3]1,[4]0
                }
            }
            return answer
        }
    }
}


fun main(){
    val hIndex = `H-index`.getSolution()
    println(hIndex.solution(intArrayOf(10,10,10,10,10)))
    println(hIndex.solution(intArrayOf(3,0,6,1,5)))
    println(hIndex.solution(intArrayOf(0,0,0,0,0)))
}
