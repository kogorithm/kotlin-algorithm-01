package `4week`.jaewon

fun solution(p: IntArray): IntArray {
    val answer = IntArray(p.size){0}
    var i = 0
    while(i < p.size){
        val j = p.indexOf(p.drop(i).minOf{it})
        if(i != j){
            val temp = p[i]
            p[i] = p[j]
            p[j] = temp
            answer[i]++
            answer[j]++
        }
        i++
    }
    return answer
}

fun main(){
    println(solution(intArrayOf(2, 5, 3, 1, 4)))
}