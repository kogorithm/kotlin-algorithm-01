package `3week`.hyunsoo



class `위장` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun solution(clothes: Array<Array<String>>): Int {
            var answer = 0
            val clothesMap = mutableMapOf<String,Int>()

            clothes.forEach {
                if (clothesMap.containsKey(it[1])){
                    clothesMap[it[1]] = clothesMap[it[1]]!! + 1
                } else {
                    clothesMap.put(it[1], 1)
                }
            }

            answer = clothesMap.map { it.value }.fold(1) {total, next -> total * (next+1) }
            return answer-1
        }
    }
}

fun main() {
    val solution = `위장`.getSolution()
    println(solution.solution(arrayOf(
        arrayOf("yellowhat", "headgear"),
        arrayOf("bluesunglasses", "eyewear"),
        arrayOf("green_turban", "headgear"),
    )))
}