package `8week`.seoyoon

class `1번` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun solution(seoul: Array<String>): String {
            return "김서방은 ${seoul.indexOf("Kim")}에 있다"
        }
    }
}