package `2week`.jaewon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var result = 0
    var n = readLine().toInt()
    val time = readLine().split(" ").map { it.toInt()}.sorted()

    time.forEach{
        result += it*n
        n--
    }
    print(result)
}
