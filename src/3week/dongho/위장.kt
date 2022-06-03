package `3week`.dongho

class `위장` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun solution(clothes: Array<Array<String>>): Int {
            val map = mutableMapOf<String, MutableSet<String>>()
            clothes.forEach { (cloth, type) ->
                val typeOfSet: MutableSet<String> = map.getOrDefault(type, mutableSetOf())
                typeOfSet.add(cloth)
                map.set(type, typeOfSet)
            }

            var answer: Int? = null
            map.forEach { type, clothes ->
                val temp = clothes.size + 1
                answer = answer?.let { answer?.times(temp) }?: temp
            }
            answer = answer?.minus(1)
            return answer!!
        }
    }
}

fun main() {
    val solution = `위장`.getSolution()
    println(solution.solution(arrayOf(arrayOf("yellowhat", "headgear"), arrayOf("bluesunglasses", "eyewear"), arrayOf("green_turban", "headgear"))))
}