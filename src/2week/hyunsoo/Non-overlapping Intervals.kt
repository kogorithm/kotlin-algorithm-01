package `2week`.hyunsoo

class Solution3 {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[1] }

        var connectedCount = 1
        val length = intervals.size

        var rightBefore = intervals[0][1]

        for (index in 1 until length){

            val (start, end) = intervals[index]

            if(rightBefore <= start){

                rightBefore = end
                connectedCount++

            }
        }

        return length - connectedCount
    }
}