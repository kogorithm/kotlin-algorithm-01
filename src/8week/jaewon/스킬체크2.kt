
class `스킬체크2` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }

        class Solution {
            fun solution(arr: IntArray): IntArray {
                var answer = arr.filter{it > arr.minOf{it}}.toMutableList()
                if(answer.isEmpty()){
                    answer.add(-1)
                }
                return answer.toIntArray()
            }
        }
    }
}