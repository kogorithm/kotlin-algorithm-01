package `6week`.hyunsoo

import java.util.Stack
class `큰 수 만들기` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun solution(number: String, k: Int): String {
            // 스택(LIFO)
            val stack = Stack<Int>()
            // 정답의 길이 = number의 길이 - 제거할 수의 개수
            val stdLen = number.length - k
            // 정답이 담길 변수
            var answer = ""
            // 지워진 개수
            var removedCnt = 0

            // 앞에 있을수록 수가 커야 더 큰 수
            number.forEach{

                val curNum = it - '0'

                // 현재 스택이 비어있지 않고,
                // 현재 탐색하는 수가 지금까지 뽑은 수보다 크고
                // 아직 숫자를 제거할 기회가 남았다면
                // stack에서 pop()
                while (stack.isNotEmpty()
                    && curNum > stack.peek()
                    && removedCnt < k){
                    stack.pop()
                    removedCnt++
                }
                stack.add(curNum)

            }

            // 길이가 stdLen보다 크다면 뒷부분 잘라주기
            if(stack.size > stdLen){
                answer = stack.subList(0, stdLen).joinToString("")
            } else answer = stack.joinToString("")

            return answer
        }

    }
}

fun main() {
    val solution = `큰 수 만들기`.getSolution()
    println(solution.solution("1924", 2))
    println(solution.solution("1231234", 3))
    println(solution.solution("4177252841", 4))

}