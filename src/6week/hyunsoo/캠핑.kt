package `6week`.hyunsoo

fun main() {

    var cnt = 1

    while (true) {

        val (l, p, v) = readln().split(" ").map { it.toInt() }
        if (l == 0 && p == 0 && v == 0) break

        val useWhole = v / p * l
        var useSperate = v % p
        if (l < useSperate) useSperate = l

        println("Case ${cnt++}: ${useWhole + useSperate}")

    }
}