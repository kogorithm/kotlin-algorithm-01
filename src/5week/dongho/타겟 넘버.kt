package `5week`.dongho

class `타겟 넘버` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution(var answer: Int = 0) {
        fun solution(numbers: IntArray, target: Int): Int {
            dfs(0, 0, numbers, target)
            return answer
        }

        fun dfs(n: Int, sum: Int, numbers: IntArray, target: Int) {
            if (n == numbers.size) {
                if (sum == target) answer++
                return
            }
            dfs(n + 1, sum + numbers[n], numbers, target)
            dfs(n + 1, sum - numbers[n], numbers, target)
        }
    }

    /*
        이거보는데 대단하더라구요 https://programmers.co.kr/learn/courses/30/lessons/43165/solution_groups?language=kotlin
     */
}

fun main() {
    println(`타겟 넘버`.getSolution().solution(intArrayOf(1, 1, 1, 1, 1), 3))
    println(`타겟 넘버`.getSolution().solution(intArrayOf(4, 1, 2, 1), 4))
}