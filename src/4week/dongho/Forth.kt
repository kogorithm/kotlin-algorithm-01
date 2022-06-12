package `4week`.dongho

import java.util.*

class Forth {
    fun getSolution(): Solution {
        return Solution()
    }

    class Solution {
        lateinit var grid: Array<String>
        lateinit var map: Array<IntArray>
        lateinit var visited: Array<BooleanArray>
        private lateinit var endPoint: Pair<Int, Int>

        val direction = arrayOf(
            Pair(1, 0),
            Pair(0, 1),
            Pair(-1, 0),
            Pair(0, -1)
        )

        fun solution(grid: Array<String>, k: Int): Int {
            this.grid = grid
            this.map = grid.map {
                it.map {
                    if (it == '#') 0 else 1
                }.toIntArray()
            }.toTypedArray()
            val col = grid.first().length
            val row = grid.size
            this.visited = Array(row) { Array(col) { false }.toBooleanArray() }
            this.visited[0][0] = true
            this.endPoint = Pair(row, col)
            bfs(0, 0)

            return (map[endPoint.first - 1][endPoint.second - 1] - 1) / k
        }

        fun bfs(x: Int, y: Int) {
            val q: Queue<Pair<Int, Int>> = LinkedList()
            q.add(Pair(x, y))
            while (!q.isEmpty()) {
                val now = q.poll()
                direction.forEach {
                    val next = now + it
                    if (next.first < 0 || next.second < 0 || next.first >= endPoint.first || next.second >= endPoint.second) {
                    } else if (visited[next.first][next.second] || map[next.first][next.second] == 0) {
                    } else {
                        q.add(next)
                        map[next.first][next.second] = map[now.first][now.second] + 1
                        visited[next.first][next.second] = true
                    }
                }
            }
        }
    }
}

private operator fun Pair<Int, Int>.plus(it: Pair<Int, Int>): Pair<Int, Int> {
    return Pair(this.first + it.first, this.second + it.second)
}

fun main() {
    val solution = Forth().getSolution()
    println(solution.solution(arrayOf("..FF", "###F", "###."), 4))
    println(solution.solution(arrayOf("..FF", "###F", "###."), 5))
    println(solution.solution(arrayOf(".F.FFFFF.F", ".########.", ".########F", "...######F", "##.######F", "...######F", ".########F", ".########.", ".#...####F", "...#......"), 6))
}