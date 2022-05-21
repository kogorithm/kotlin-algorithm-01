package `1week`.dongho

import kotlin.math.abs

class inputKeypad {
    fun getSolution(): Solution {
        return Solution()
    }

    class Solution {
        companion object {
            val numIdx = mapOf<Char, Pair<Int, Int>>(
                '1' to Pair(0, 0),
                '4' to Pair(0, 1),
                '7' to Pair(0, 2),
                '*' to Pair(0, 2),
                '2' to Pair(1, 0),
                '5' to Pair(1, 1),
                '8' to Pair(1, 2),
                '0' to Pair(1, 3),
                '3' to Pair(2, 0),
                '6' to Pair(2, 1),
                '9' to Pair(2, 2),
                '#' to Pair(2, 3)
            )
        }

        var lHand: Pair<Int, Int> = numIdx.get('*')!!
        var rHand: Pair<Int, Int> = numIdx.get('#')!!
        var answer = StringBuffer()

        fun getSelect(value: Char, hand: String) {
            when (value) {
                '1', '4', '7', '*' -> {
                    answer.append('L')
                    lHand = numIdx.get(value)!!
                }
                '3', '6', '9', '#' -> {
                    answer.append('R')
                    rHand = numIdx.get(value)!!
                }
                else -> {
                    numIdx.get(value)?.let { (x, y) ->
                        val lDiff = abs(lHand.first - x) + abs(lHand.second - y)
                        val rDiff = abs(rHand.first - x) + abs(rHand.second - y)
                        if (lDiff == rDiff) {
                            if (hand == "right") {
                                answer.append('R')
                                rHand = numIdx.get(value)!!
                            } else {
                                answer.append('L')
                                lHand = numIdx.get(value)!!
                            }
                        } else if (lDiff > rDiff) {
                            answer.append('R')
                            rHand = numIdx.get(value)!!
                        } else {
                            answer.append('L')
                            lHand = numIdx.get(value)!!
                        }
                    }
                }
            }
        }

        fun solution(numbers: IntArray, hand: String): String {
            numbers.forEach { getSelect(Character.forDigit(it, 10), hand) }
            return answer.toString()
        }
    }
}

fun main() {
    val solution = inputKeypad().getSolution()
    println(solution.solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right"))
    println(solution.solution(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2), "left"))
    println(solution.solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), "right"))
}