package `5week`.dongho

import java.io.*
import kotlin.properties.Delegates

class `전쟁-전투` {
    private var N by Delegates.notNull<Int>()
    private var M by Delegates.notNull<Int>()
    private var map: Array<CharArray>
    private var visit: Array<BooleanArray>
    private var count = 0

    var result: Pair<Int, Int>

    constructor(N:Int, M: Int, map: Array<CharArray>) {
        this.map = map
        this.visit = Array(M) { BooleanArray(N) }
        this.N = N
        this.M = M

        var whiteCount = 0
        var blackCount = 0
        for (i in 0 until  M) {
            for (j in 0 until N) {
                if (!visit[i][j]) {
                    val color: Char = map[i][j]
                    count = 0
                    dfs(Pair(i, j), color)

                    if (color == 'W') {
                        whiteCount += count * count
                    } else {
                        blackCount += count * count
                    }
                }
            }
        }
        result = Pair(whiteCount, blackCount)
    }

    companion object {
        private val direction = arrayOf(
            Pair(1, 0),
            Pair(0, 1),
            Pair(-1, 0),
            Pair(0, -1)
        )
    }

    private fun dfs(position: Pair<Int, Int>, color: Char) {
        visit[position.first][position.second] = true
        count += 1
        direction.forEach { dir ->
            val np = position + dir
            if (rangeCheck(np) && map[np.first][np.second] === color && visit[np.first][np.second] === false) {
                dfs(np, map[np.first][np.second])
            }
        }
    }


    private fun rangeCheck(position: Pair<Int, Int>): Boolean {
        return position.first in 0 until M && 0 <= position.second && position.second < N
    }
}

private operator fun Pair<Int, Int>.plus(it: Pair<Int, Int>): Pair<Int, Int> {
    return Pair(this.first + it.first, this.second + it.second)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(M) { CharArray(N) }
    for (i in 0 until M) {
        val str = br.readLine()
        for (j in 0 until N) {
            val ch = str[j]
            map[i][j] = ch
        }
    }

    println(`전쟁-전투`(N, M, map).result.run { "$first $second" })
}
