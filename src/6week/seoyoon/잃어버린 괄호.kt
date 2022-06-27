package `6week`.seoyoon

fun main() {
    var answer = 0
    val str = readln().split("-").toMutableList()
    repeat(str.size) {
        if (str[it].contains("+")) {
            var midSum = str[it].split("+").map{ it.toInt() }.reduce{total, sum -> total + sum}
            str[it] = midSum.toString()
        }
    }
    answer = str.map{ it.toInt() }.reduce{ total, sum -> total - sum }
    println(answer)
}