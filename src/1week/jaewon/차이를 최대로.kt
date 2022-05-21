package `1week`.jaewon

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var result = 0
    val n = readLine().toInt()
    val array = readLine().split(" ").map { it.toInt() }

    permutation(array).forEach {
        val temp = calculate(it,n)
        result = max(result,temp)
    }

    print(result)
}

fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el ): List<List<T>> {
    return if(sub.isEmpty()) listOf(fin)
    else sub.flatMap { permutation(el, fin + it, sub - it) }
}

fun calculate(list : List<Int>, n : Int) : Int{
    var sum = 0
    for(i in 0 until n-1){
        sum += abs(list[i]-list[i+1])
    }
    return sum
}