package `5week`.dongho

import java.util.*
import kotlin.math.abs

class `거리두기 확인하기` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {
        companion object {
            private val direction = arrayOf(
                Pair(1, 0),
                Pair(0, 1),
                Pair(-1, 0),
                Pair(0, -1)
            )
        }

        lateinit var place: Array<String>
        var row: Int = 0
        var col: Int = 0

        fun solution(places: Array<Array<String>>): IntArray {
            return places.map { place ->
                row = place.size - 1
                col = place.first().length - 1
                this.place = place
                for (i in 0 until row) {
                    for (j in 0 until col) {
                        val temp = place[i][j]
                        if (temp == 'P') {
                            if (!bfs(Pair(i, j))) {
                                return@map 0
                            }
                        }
                    }
                }
                return@map 1
            }.toIntArray()
        }

        operator fun Pair<Int, Int>.plus(it: Pair<Int, Int>): Pair<Int, Int> {
            return Pair(this.first + it.first, this.second + it.second)
        }

        private fun bfs(point: Pair<Int, Int>): Boolean {
            val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
            queue.offer(point)
            while (queue.isNotEmpty()) {
                val position = queue.poll()
                direction.forEach { dir ->
                    val newPoint = position + dir
                    if (!(newPoint.first < 0 || newPoint.second < 0 || newPoint.first >= row || newPoint.second >= col || newPoint == point)) {
                        val distance = abs(newPoint.first - point.first) + abs(newPoint.second - point.second)
                        if (place[newPoint.first][newPoint.second] == 'P' && distance <= 2) {
                            return false
                        } else if (place[newPoint.first][newPoint.second] == 'O' && distance < 2) {
                            queue.offer(newPoint)
                        }
                    }
                }
            }
            return true
        }
    }
}

fun main() {
    println(`거리두기 확인하기`.getSolution().solution(arrayOf(
        arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
        arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
        arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
        arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"),
    )).contentToString())
}