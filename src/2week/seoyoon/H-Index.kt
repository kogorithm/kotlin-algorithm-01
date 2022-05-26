package `2week`.seoyoon

import java.lang.Integer.max
import java.lang.Integer.min

fun solution(citations: IntArray): Int {
    var answer = 0
    citations.sort()

    for (i in 0 until citations.size) {
        var min = min(citations[i], citations.size - i)
        answer = max(min, answer)
    }
    return answer
}