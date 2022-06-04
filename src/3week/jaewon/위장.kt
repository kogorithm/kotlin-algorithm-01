package `3week`.jaewon

class `위장` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }
    class Solution{
        fun solution(clothes: Array<Array<String>>): Int{
            var multiple = 1
            clothes.groupingBy {it[1]}.eachCount().values.forEach{ multiple *= (it+1)}
            return multiple-1
        }
    }
}

fun main(){
    val solution = 위장.getSolution()
    println(solution.solution(arrayOf(arrayOf("yellowhat", "headgear"),
                                        arrayOf("bluesunglasses", "eyewear"),
                                        arrayOf("green_turban", "headgear"))))
}