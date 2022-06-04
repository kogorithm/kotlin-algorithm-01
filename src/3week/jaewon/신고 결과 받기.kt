package `3week`.jaewon

class `신고 결과 받기` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }
    class Solution {
        fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
            val noOverLap = ((report.groupBy{it.split(" ")[1]}).values.map{it.distinct()})
            val temp = id_list.associateWith { 0 }.toMutableMap()

            noOverLap.forEach {
                if (it.size >= k) {
                    val reporters = it.map {reporter -> reporter.split(" ")[0]}
                    reporters.forEach { reporter ->
                        temp[reporter] = temp[reporter]!! + 1
                    }
                }
            }
            return temp.values.toIntArray()
        }
    }
}
