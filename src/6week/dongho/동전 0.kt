package `6week`.dongho

import java.io.*
import kotlin.math.floor

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (length, value) = br.readLine().split(" ")
    var doubleValue = value.toDouble()
    val coinList = Array(length.toInt()) {
        br.readLine().toInt()
    }.apply { reverse() }
    println(coinList.sumOf {
        val append = floor(doubleValue / it)
        doubleValue %= it
        append
    }.toInt())
}