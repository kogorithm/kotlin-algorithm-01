package `4week`.jaewon

fun solution(n: Int, plans: Array<String>, clients: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()
    val newPlans = mutableListOf<List<String>>()

    val newPlan = arrayOf<List<String>>()
    plans.forEach{
        val cut = it.split(" ")
        cut.forEachIndexed{ idx, v ->
            newPlan
        }
    }

    clients.forEach{
        plans.filterIndexed{ inx, v ->
            val phone = v.split(" ").map {it.toInt()}
            it.split(" ")[0].toInt() <phone[0]
        }
    }

    return answer
}

fun main(){

}