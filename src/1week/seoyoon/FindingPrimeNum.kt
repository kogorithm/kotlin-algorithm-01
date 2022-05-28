import kotlin.math.sqrt

class Week1SYSolution {
    var visited = BooleanArray(7, {false})
    val set: MutableSet<Int> = mutableSetOf()
    var depth: Int = 0

    fun solution(numbers: String): Int {
        var answer = 0
        findPrimes(numbers,0, "")
        answer = set.size

        return answer
    }

    fun findPrimes(numbers: String, depth: Int, cur: String) {
        if (depth == numbers.length) return

        for (i in 0 until numbers.length) {
            if (visited[i] == true) {
                continue
            }
            else {
                var number = cur + numbers[i]

                if (isPrime(number.toInt())) {
                    set.add(number.toInt())
                }
                visited[i] = true
                findPrimes(numbers, depth + 1, number)
                visited[i] = false
            }
        }
    }

    fun isPrime(num: Int): Boolean {
        if (num <= 1) return false
        if (num > 1) {
            for (i in 2 .. sqrt(num.toDouble()).toInt()) {
                if (num % i == 0) return false
            }
        }
        return true
    }
}