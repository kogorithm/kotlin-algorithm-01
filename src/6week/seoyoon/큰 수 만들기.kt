package `6week`.seoyoon

class `큰 수 만들기` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun solution(number: String, k: Int): String {
            var answer = StringBuilder()
            var idx = 0

            for (i in 0 until number.length) {
                if (answer.length == number.length - k) {
                    return answer.toString()
                }
                var max = 0
                for (j in idx .. k + i) {
                    if (number[j].digitToInt() > max) {
                        max = number[j].digitToInt()
                        idx = j + 1
                    }
                }
                answer.append(max)
            }
            return answer.toString()
        }
    }
}

fun main() {
    val solution = `큰 수 만들기`.getSolution()
    println(solution.solution("1924", 2))
    println(solution.solution("1231234", 3))
    println(solution.solution("4177252841", 4))
}