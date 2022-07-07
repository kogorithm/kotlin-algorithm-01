package `7week`.jaewon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val m = br.readLine().toInt()
    val gift = PriorityQueue(Collections.reverseOrder<Int>())
    repeat(m){
        val st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        if(n == 0){
            if(gift.isNotEmpty()){
                println(gift.poll())
            }else{
                println(-1)
            }
        }else{
            repeat(n){
                gift.add(st.nextToken().toInt())
            }
        }
    }
}