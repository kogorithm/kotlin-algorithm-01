package `9week`.dongho

class First {
    fun getSolution(): Solution {
        return Solution()
    }

    class Solution {
        fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
            return commands.map { (i, j, k) -> array.slice(i - 1 until j).sorted().get(k - 1) }.toIntArray()
        }
    }
}

fun main() {
    val solution = First().getSolution()
    println(
        solution.solution(
            intArrayOf(1, 5, 2, 6, 3, 7, 4),
            arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
        ).contentToString()
    )
}