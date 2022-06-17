package `5week`.seoyoon

var answer = 0

class `타겟 넘버` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun solution(numbers: IntArray, target: Int): Int {
            answer = 0
            BFS(numbers, target, 0, 0, 0)
            return answer
        }
    }
}

fun BFS(numbers: IntArray, target: Int, depth: Int, sum: Int, idx: Int) {
    if (depth == numbers.size) {
        if (sum == target) {
            answer++
        }
        return
    }
    BFS(numbers, target, depth + 1, sum + numbers[idx], idx + 1)
    BFS(numbers, target, depth + 1, sum - numbers[idx], idx + 1)
}

fun main() {
    val solution = `타겟 넘버`.getSolution()
    println(solution.solution(intArrayOf(1, 1, 1, 1, 1), 3))
    println(solution.solution(intArrayOf(4, 1, 2, 1), 4))
}