package `9week`.hyunsoo

class `1`{
    fun getSolution(): Solution {
        return Solution()
    }

    class Solution {
        fun solution(n: Int): Int {
            return getAnswer(n)
        }

        fun getAnswer(n: Int): Int{
            for(no in 1 until n){
                if( n % no == 1) return no
            }
            return 0
        }
    }


}

fun main() {
    val solution = `1`().getSolution()
    println(solution.solution(10))
    println(solution.solution(12))
}