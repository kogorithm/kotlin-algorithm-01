package `2week`.hyunsoo

class Solution2 {
    fun solution(citations: IntArray): Int {
        var answer = 0
        citations.sort()

        for (no in 0 .. citations.maxOf { it }){
            var quote = 0
            var notQuote = 0
            citations.forEach {
                if (no <= it) quote++
                else notQuote++
            }
            if (quote >= no && quote >= answer && quote >= notQuote) answer = no
        }
        return answer
    }
}