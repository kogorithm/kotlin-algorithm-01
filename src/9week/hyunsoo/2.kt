package `9week`.hyunsoo

class `2`{
    fun getSolution(): Solution {
        return Solution()
    }

    class Solution {
        fun solution(sizes: Array<IntArray>): Int {

            var sizeData = sizes

            for(i in 0 until sizeData.size){
                if(sizeData[i][0] < sizeData[i][1]){
                    var temp = sizeData[i][1]
                    sizeData[i][1] = sizeData[i][0]
                    sizeData[i][0] = temp
                }

            }

            return sizeData.maxOf{ it[0] } * sizeData.maxOf{ it[1] }
        }

    }


}

fun main() {
    val solution = `2`().getSolution()
    println(
        solution.solution(
            arrayOf(intArrayOf(60,50),intArrayOf(30,70),intArrayOf(60,30),
                intArrayOf(80,40))
        )
    )
    println(
        solution.solution(
            arrayOf(intArrayOf(10,7),intArrayOf(12,3),intArrayOf(8,15),
                intArrayOf(14,7),intArrayOf(5,15))
        )
    )
    println(
        solution.solution(
            arrayOf(intArrayOf(14,4),intArrayOf(19,6),intArrayOf(6,16),
                intArrayOf(18,7),intArrayOf(7,11))
        )
    )
}