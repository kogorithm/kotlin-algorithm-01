package `5week`.hyunsoo


class `타겟 넘버` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {

        var answer = 0

        fun solution(numbers: IntArray, target: Int): Int {

            dfs(0,numbers,target,0)
            return answer
        }

        fun dfs(cnt: Int, numbers: IntArray, target: Int, sum: Int){

            if(cnt == numbers.size) {
                if(sum == target) answer++
                return
            }

            dfs(cnt+1,numbers,target,sum + numbers[cnt])
            dfs(cnt+1,numbers,target,sum - numbers[cnt])

        }
    }
}

fun main() {
    println(`타겟 넘버`.getSolution().solution(intArrayOf(1, 1, 1, 1, 1), 3))
    println(`타겟 넘버`.getSolution().solution(intArrayOf(4, 1, 2, 1), 4))
}