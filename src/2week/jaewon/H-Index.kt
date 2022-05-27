package `2week`.jaewon

fun main(){
    println(hIndex(intArrayOf(10,10,10,10,10)))
    println(hIndex(intArrayOf(3,0,6,1,5)))
    println(hIndex(intArrayOf(0,0,0,0,0)))
}

fun hIndex(citations: IntArray): Int {
    var answer = 0
    citations.sortedDescending().forEachIndexed{ index, num ->
        if( index+1 <= num ){ // 인용된 논문의 횟수보다 인용되지 않은 논문의 횟수가 더 많아지는 지점.
            answer = index+1
        }
    }
    return answer
}
