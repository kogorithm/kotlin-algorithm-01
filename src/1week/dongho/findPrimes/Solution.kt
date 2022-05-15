package `1week`.dongho.findPrimes

class Solution {
    fun <T> List<T>.permutation(num: Int): List<List<T>> {
        if (num == 1) {
            return map { v: T ->
                listOf(v)
            }
        }
        val result = mutableListOf<List<T>>()
        val length = size
        for (i in 0 until length) {
            val current: T = this[i]
            val permutations = mutableListOf<T>().let {
                it.addAll(this.subList(0, i))
                it.addAll(this.subList(i + 1, length))
                it
            }.permutation(num - 1)
            val attach = permutations.map { permutation ->
                mutableListOf(current).run {
                    addAll(permutation)
                    this
                }
            }
            result.addAll(attach)
        }
        return result.toList()
    }

    private fun isPrime(num: Int): Boolean {
        if (num <= 1) {
            return false
        }
        var i = 2
        while (i * i <= num) {
            if (num % i == 0) return false
            i++
        }
        return true
    }

    fun solution(numbers: String): Int {
        val intArr = numbers.toCharArray().map { it - '0' }
        val length = intArr.size
        val answer = IntRange(1, length).fold(mutableSetOf<Int>()) { prev, index ->
            val result = intArr.permutation(index)
                .map { it.map { it.toString() }.joinToString("").toInt() }
                .filter { isPrime(it) }
            prev.addAll(result)
            prev
        }.size
        return answer
    }
}

fun main() {
    val solution = Solution()
    println(solution.solution("17"))
    println(solution.solution("011"))
}