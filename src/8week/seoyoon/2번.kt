package `8week`.seoyoon

class `2번` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun solution(num: Int): String {
            if (num % 2 == 0) {
                return "Even"
            } else {
                return "Odd"
            }
        }
    }
}