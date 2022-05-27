package `2week`.dongho

class `H-index` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun solution(citations: IntArray): Int {
            var answer = 0
            citations.sort()
            val length = citations.size
            for (i in 0 until length) {
                val diff = length - i
                val v = citations[i]
                if (diff <= v) {
                    answer = diff
                    break
                }
            }
            return answer
        }
    }
}

fun main() {
    val solution = `H-index`.getSolution()
    println(solution.solution(intArrayOf(3, 0, 6, 1, 5)))
}