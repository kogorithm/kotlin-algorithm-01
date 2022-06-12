package `4week`.dongho

class Third {
    fun getSolution(): Solution {
        return Solution()
    }

    class Solution {
        fun planToMap(vararg options: Int): Pair<Int, Set<Int>> {
            return Pair(options.first(), options.slice(1 until  options.size).toSet())
        }

        fun solution(n: Int, plans: Array<String>, clients: Array<String>): IntArray {
            val planList = plans.fold(mutableListOf<Pair<Int, Set<Int>>>()) { prev, it ->
                val appendPlan = planToMap(*it.split(" ").map { it.toInt() }.toIntArray())
                if (prev.isNotEmpty()) {
                    val tempOptional = mutableSetOf<Int>()
                    tempOptional.addAll(prev.last().second)
                    tempOptional.addAll(appendPlan.second)
                    prev.add(Pair(appendPlan.first, tempOptional))
                } else {
                    prev.add(appendPlan)
                }
                prev
            }

            return clients.map {
                val (data, optionalSet) = planToMap(*it.split(" ").map { it.toInt() }.toIntArray())
                planList.filter { it.first > data && it.second.containsAll(optionalSet) }
                var answer = 0
                for (i in 0 until planList.size) {
                    val current = planList.get(i)
                    if (current.first >= data && current.second.containsAll(optionalSet)) {
                        answer = i + 1
                        break
                    }
                }
                answer
            }.toIntArray()
        }
    }
}

fun main() {
    val solution = Third().getSolution()
    println(solution.solution(5,
        arrayOf("100 1 3", "500 4", "2000 5"),
        arrayOf("300 3 5", "1500 1", "100 1 3", "50 1 2")).contentToString())
}