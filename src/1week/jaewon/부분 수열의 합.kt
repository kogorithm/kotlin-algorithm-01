package `1week`.jaewon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var result = 0
    val st = StringTokenizer(readLine(), " ")
    val n = st.nextToken().toInt()
    val s = st.nextToken().toInt()
    val sequence = readLine().split(" ").map { it.toInt()}

    if(sequence.sum() == s){
        result = 1
    }else if(sequence.sum() < s){
        result = 0
    }

    for(i in 1 until n){
        val answer = mutableListOf<List<Int>>()
        combination(answer,sequence,Array<Boolean>(n){false},0,i)
        answer.forEach {
            if(it.sum() == s){
                result++
            }
        }
    }
    
    print(result)
}

fun <T> combination(answer: MutableList<List<T>>, el: List<T>, ck: Array<Boolean>, start: Int, target: Int) {
    if(target == 0) {
        answer.addAll( listOf(el.filterIndexed { index, t -> ck[index] }) )
    } else {
        for(i in start until el.size) {
            ck[i] = true
            combination(answer, el, ck, i + 1, target - 1)
            ck[i] = false
        }
    }
}