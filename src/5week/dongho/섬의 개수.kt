package `5week`.dongho

import java.io.*

class `섬의 개수` {
    var arr: Array<BooleanArray>
    var visit: Array<BooleanArray>
    var w: Int
    var h: Int
    var cnt: Int

    companion object {
        val direction = arrayOf(
            Pair(0, 1),
            Pair(0, -1),
            Pair(1, 0),
            Pair(-1, 0),
            Pair(-1, -1),
            Pair(1, 1),
            Pair(-1, 1),
            Pair(1, -1)
        )
    }

    constructor(w: Int, h: Int, arr: Array<BooleanArray>, visit: Array<BooleanArray>) {
        this.w = w
        this.h = h
        this.arr = arr
        this.visit = visit
        this.cnt = 0

        for (i in 1..h) {
            for (j in 1..w) {
                if (arr[i][j] && !visit[i][j]) {
                    cnt += dfs(Pair(i, j))
                }
            }
        }
    }

    private fun dfs(point: Pair<Int, Int>): Int {
        visit[point.first][point.second] = true
        direction.forEach {
            val nextPoint = point + it
            if (nextPoint.first > 0 && nextPoint.second > 0 && nextPoint.first <= h && nextPoint.second <= w) {
                if (arr[nextPoint.first][nextPoint.second] && !visit[nextPoint.first][nextPoint.second]) {
                    dfs(nextPoint)
                }
            }
        }
        return 1
    }

    fun getCount() = cnt

    private operator fun Pair<Int, Int>.plus(it: Pair<Int, Int>): Pair<Int, Int> {
        return Pair(this.first + it.first, this.second + it.second)
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        if (w == 0 && h == 0) break
        val realW = w + 1
        val realH = h + 1
        val arr = Array(realH) { BooleanArray(realW) }
        val visit = Array(realH) { BooleanArray(realW) }
        for (i in 1..h) {
            arr[i] = booleanArrayOf(false, *br.readLine().split(" ").map { it == "1" }.toBooleanArray())
        }
        println(`섬의 개수`(w, h, arr, visit).getCount())
    }
}