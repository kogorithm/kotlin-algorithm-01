package `6week`.jaewon

import java.util.Stack

class `큰 수 만들기` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution{
        fun solution(number: String, k: Int): String {
            var answer = ""
            var start = 0
            while (start < number.length && answer.length != number.length-k){
                val front = k + answer.length +1
                var max = 0
                for(i in start until front){
                    if(max < number[i].digitToInt()){
                        max = number[i].digitToInt()
                        start = i +1
                    }
                }
                answer = "${answer}${max}"
            }
            return answer
        }
    }
}

fun main() {
    val solution = `큰 수 만들기`.getSolution()
    println(solution.solution("1924",2))
    println(solution.solution("1231234",3))
    println(solution.solution("4177252841",4))
}