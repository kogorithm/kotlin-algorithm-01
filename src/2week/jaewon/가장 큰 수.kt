package `2week`.jaewon


class `가장 큰 수` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun solution(numbers: IntArray): String {
            var answer = numbers.sortedWith { a, b ->
                val aString = a.toString()
                val bString = b.toString()
                ("$bString$aString").compareTo("$aString$bString")
            }.joinToString("")


            return if(answer[0] == '0') "0" else answer
        }
    }
}

fun main(){
    println(`가장 큰 수`.getSolution().solution(intArrayOf(0,0,0,70)))
}

