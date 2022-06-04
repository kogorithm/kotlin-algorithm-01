package `3week`.seoyoon

class `위장` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }
    class Solution {
        fun solution(clothes: Array<Array<String>>): Int  {
            var answer = 1
            val ClothesMap = HashMap<String, Int>()

            repeat(clothes.size) {
                ClothesMap.put(clothes[it][1], ClothesMap.getOrDefault(clothes[it][1], 0) + 1)
            }

//            for (key in map.keys) { answer *= (map[key]!! + 1) } -> fold 변경
            answer = ClothesMap.map{ it.value }.fold(1) { total, num -> total * (num + 1)}

            return answer - 1
        }
    }
}

fun main() {
    val solution = `위장`.getSolution()
    val arr = arrayOf(
        arrayOf("yellowhat", "headgear"),
        arrayOf("bluesunglasses", "eyewear"),
        arrayOf("green_turban", "headgear")
    )
    println(solution.solution(arr))
}