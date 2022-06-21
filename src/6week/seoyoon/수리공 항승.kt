package `6week`.seoyoon

fun main() {
    val (N, L) = readln().split(" ").map{ it.toInt() }
    val water = readln().split(" ").map{ it.toInt() }.toIntArray()
    var cnt = 1

    water.sort()
    var tape = water[0] + L - 0.5

    for (i in 1 until N) {
        if (tape < water[i]) {
            cnt++
            tape = water[i] + L - 0.5
        }
    }
    println(cnt)
}