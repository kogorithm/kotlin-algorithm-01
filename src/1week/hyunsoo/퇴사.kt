import kotlin.math.max
fun main(){

    val size = readln().toInt()
    val day = IntArray(size+2, {0})
    val pay = IntArray(size+2, {0})
    val maxPay = IntArray(size+2, {0})

    for (index in 1 .. size){
        val inputdata = readln().split(" ").map { it.toInt() }
        day[index] = inputdata[0]
        pay[index] = inputdata[1]
        maxPay[index] = 0
    }

    if (day[size] == 1) maxPay[size] = pay[size]

    for (i in size-1 downTo 1){

        if (day[i] + i -1 > size) maxPay[i] = maxPay[i+1]
        else maxPay[i] = max(pay[i] + maxPay[i+day[i]], maxPay[i+1])

    }

    println(maxPay[1])
}