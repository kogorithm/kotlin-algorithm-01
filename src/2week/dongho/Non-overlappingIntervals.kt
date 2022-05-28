package `2week`.dongho

class `Non-overlappingIntervals` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
            var connectedCount = 1
            val length = intervals.size
            intervals.sortWith(Comparator { a: IntArray, b: IntArray -> a[1] - b[1] })
            var prevEnd = intervals.first().get(1)
            for (i in 1 until length) {
                val (start, end) = intervals.get(i)
                if (prevEnd <= start) {
                    prevEnd = end
                    connectedCount++
                }
            }
            return length - connectedCount
        }
    }
}

fun main() {
    val solution = `Non-overlappingIntervals`.getSolution()
    println(solution.eraseOverlapIntervals(arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(1, 3)
    )))
    println(solution.eraseOverlapIntervals(arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 2),
        intArrayOf(1, 2)
    )))
    println(solution.eraseOverlapIntervals(arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
    )))
    println(solution.eraseOverlapIntervals(arrayOf(
        intArrayOf(1, 100),
        intArrayOf(11, 22),
        intArrayOf(1, 11),
        intArrayOf(2, 12),
    )))
}