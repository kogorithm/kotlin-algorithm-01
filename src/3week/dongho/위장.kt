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
            // 타입별로 그룹핑
            clothes.forEach { (cloth, type) ->
                val typeOfSet: MutableSet<String> = map.getOrDefault(type, mutableSetOf())
                typeOfSet.add(cloth)
                map.set(type, typeOfSet)
            }

            var answer: Int = 1
            // 가능한 갯수에 안입는다는 선택지를 포함한 갯수의 곱
            map.forEach { _, clothes ->
                val temp = clothes.size + 1
                answer *= temp
            }
            // 전체 종류 모자 2 / 안경 1
            // 모자 갯수 + 모자없음 = 3
            // 안경 갯수 + 안경없음 = 2
            // 갯수들의 곱에 완전히 안입기는 빼기 1
            return answer - 1
        }
    }
}

fun main() {
    val solution = `위장`.getSolution()
    println(solution.solution(arrayOf(arrayOf("yellowhat", "headgear"), arrayOf("bluesunglasses", "eyewear"), arrayOf("green_turban", "headgear"))))
}