import java.util.StringTokenizer

fun main() {
    val (n, m ,b) = readln().split(" ").map{it.toInt()}
    val ground = Array(n, {IntArray(m, {0})})

    var high = Int.MIN_VALUE
    var low = Int.MAX_VALUE

    for (i in 0 until n) {
        val st = StringTokenizer(readln(), " ")
        for (j in 0 until m) {
            ground[i][j] = Integer.parseInt(st.nextToken())
            high = Math.max(high, ground[i][j])
            low = Math.min(low, ground[i][j])
        }
    }

    solution(n, m, b, ground, high, low)
}

fun solution(n: Int, m: Int, b: Int, ground: Array<IntArray>, high: Int, low: Int) {
    var ansSec = Int.MAX_VALUE
    var ansHigh = 0

    for (x in low .. high) {
        var sec = 0
        var tmpB = b

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (ground[i][j] > x) {
                    sec += (ground[i][j] - x) * 2
                    tmpB += (ground[i][j] - x)
                }
                else if (ground[i][j] < x) {
                    sec += (x - ground[i][j]);
                    tmpB -= (x - ground[i][j]);
                }
            }
        }

        if (tmpB >= 0 && sec <= ansSec) {
            ansSec = sec
            ansHigh = x
        }
    }
    print("$ansSec $ansHigh")
}