package `6week`.dongho

class `큰 수 만들기` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun solution(number: String, k: Int): String {
            val answer = StringBuilder()
            var index = 0
            var comp: Int
            repeat(number.length - k) {
                comp = 0
                for (i in index..it + k) {
                    val num = number[i] - '0'
                    if (comp < num) {
                        comp = num
                        index = i + 1
                    }
                }
                answer.append(comp)
            }
            return answer.toString()
        }
    }
}

fun main() {
    println(`큰 수 만들기`.getSolution().solution("1924", 2))
    println(`큰 수 만들기`.getSolution().solution("1231234", 3))
    println(`큰 수 만들기`.getSolution().solution("4177252841", 4))
}