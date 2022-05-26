package `2week`.dongho

class Solution {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    fun solution(numbers: IntArray): String {
        val answer = numbers.sortedWith { a, b -> ("$b$a").compareTo("$a$b") }.joinToString("") { it.toString() }
        return if (answer.first() === '0') "0" else answer
    }
}

fun main() {
    val solution = Solution.getSolution()
    println(solution.solution(intArrayOf(6, 10, 2)))
    println(solution.solution(intArrayOf(3, 30, 34, 5, 9)))
}