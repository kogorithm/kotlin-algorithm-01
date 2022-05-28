package `2week`.seoyoon

class `Non-Overlapping Intervals` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }
    class Solution {
        fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
            var count = 1

            intervals.sortBy { it[1] }
            var prevEnd = intervals.first().get(1)
            for (i in 1 until intervals.size) {
                val (start, end) = intervals.get(1)
                if (prevEnd <= start) {
                    prevEnd = end
                    count++
                }
            }
            return intervals.size - count
        }
    }
}

fun main() {
    val solution = `Non-Overlapping Intervals`.getSolution()
    println(solution.eraseOverlapIntervals(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(1, 3))))
}