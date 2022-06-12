package `4week`.jaewon

class SK_1 {
    fun getSolution(): Solution {
        return Solution()
    }

    class Solution{
        fun solution(p: IntArray): IntArray {
        val answer = IntArray(p.size){0}
        var i = 0
        while(i < p.size){
            val j = p.indexOf(p.drop(i).minOf{it})
            if(i != j){
                val temp = p[i]
                p[i] = p[j]
                p[j] = temp
                answer[i]++
                answer[j]++
            }
            i++
        }

        return answer
    }
    }
}

fun main(){
    val solution = SK_1().getSolution()
    println(solution.solution(intArrayOf(2, 5, 3, 1, 4)))
}