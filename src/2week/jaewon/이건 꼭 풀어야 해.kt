package `2week`.jaewon

import java.io.*

fun main()  {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val(n,q) = br.readLine().split(" ").map { it.toInt()}
    val numbers = br.readLine().split(" ").map { it.toInt()}.sorted()
    val sumList = Array(n+1) { 0 }

    numbers.forEachIndexed { index, i ->
        sumList[index+1] = sumList[index]+i
    }

    repeat(q){
        val (start,end) = br.readLine().split(" ").map { it.toInt()}
        val answer = sumList[end]-sumList[start-1]

        bw.write("$answer\n")
    }

    bw.flush()
    bw.close()
}