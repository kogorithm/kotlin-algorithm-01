package `1week`.jaewon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m,b) = readLine().split(" ").map { it.toInt()}
    val array = Array(n) { Array(m) { 0 } }
    var min = 0
    var minTime = Int.MAX_VALUE
    var sum : Long = 0

    for(i in 0 until n){
        val st = StringTokenizer(readLine(), " ")
        for(j in 0 until m){
            array[i][j] = Integer.parseInt(st.nextToken())
            sum += array[i][j]
        }
    }

    val average : Long = (sum+b)/(n*m)
    val maxHeight = if (average>256)256 else average.toInt()
    for(targetHeight in 0..maxHeight){
        var time = 0
        for(l in 0 until n){
            for(z in 0 until m){
                if (array[l][z] > targetHeight){
                    time += (array[l][z] - targetHeight) * 2
                }else if (array[l][z] < targetHeight){
                    time += targetHeight-array[l][z]
                }
            }
        }
        if(minTime >= time){
            minTime = time
            min = targetHeight
        }
    }

    print("$minTime $min")
}