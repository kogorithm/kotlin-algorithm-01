package `2week`.jaewon

fun main(){
    println(solution(intArrayOf(0,0,0,70)))

}

fun solution(numbers: IntArray): String {
    var answer = ""
    numbers.sortedWith(Comparator { a, b ->
        val aString = a.toString()
        val bString = b.toString()
        (bString+aString).compareTo(aString+bString)
    }).forEach { answer += it.toString() }

    if(answer[0] == '0') answer ="0"

    return answer
}