package `5week`.hyunsoo

import java.util.*

class `거리두기 확인` {
    companion object {
        fun getSolution(): Solution {
            return Solution()
        }
    }

    class Solution {

        fun solution(places: Array<Array<String>>): IntArray {

            var answer = intArrayOf()

            places.forEach { curRoom ->

                // 거리두기 규칙을 지켰는지 여부
                var followed = true

                for (x in 0 until 5){
                    for (y in 0 until 5){
                        if (!check(x,y,curRoom)) {
                            followed = false
                        }
                    }
                }
                // 규칙을 따랐다면
                if (followed) answer += 1
                // 규칙을 따르지 않았다면
                else answer += 0

            }

            return answer
        }

        fun check(x: Int, y: Int, room: Array<String>): Boolean{

            val curCell = room[x][y]
            // 응시자가 있는 자리가 아니라면 탐색을 하지 않음
            if (curCell != 'P') return true

            // 상하좌우 탐색
            val dx = intArrayOf(-1,1,0,0)
            val dy = intArrayOf(0,0,-1,1)

            for (no in 0 until 4){
                if (x + dx[no] < 0 || x + dx[no] >= 5 || y + dy[no] < 0 || y + dy[no] >= 5) continue
                if (room[x+dx[no]][y+dy[no]] == 'P')
                    return false
            }

            // 건너건너도 탐색
            val dx2 = intArrayOf(-2,2,0,0)
            val dy2 = intArrayOf(0,0,-2,2)

            for (no in 0 until 4){
                if (x + dx2[no] < 0 || x + dx2[no] >= 5 || y + dy2[no] < 0 || y + dy2[no] >= 5) continue
                // 건너건너에 사람이 존재하면서, 그 사이에 테이블도 아닌경우
                if(room[x+dx2[no]][y+dy2[no]] == 'P' && room[x+dx[no]][y+dy[no]] != 'X')
                    return false
            }

            // 대각선 탐색(좌상, 우상, 우하, 좌하 순)
            val dx3 = intArrayOf(-1,-1,1,1)
            val dy3 = intArrayOf(-1,1,1,-1)

            for (no in 0 until 4){
                if (x + dx3[no] < 0 || x + dx3[no] >= 5 || y + dy3[no] < 0 || y + dy3[no] >= 5) continue
                // 대각선에 사람이 존재하면서 사이에 파티션으로 가려지지 않은 경우
                if (room[x+dx3[no]][y+dy3[no]] == 'P'
                    && (room[x+dx3[no]][y] != 'X' || room[x][y+dy3[no]] != 'X')) return false
            }

            return true

        }

    }

}

val places: Array<Array<String>> = arrayOf(
    arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
    arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
    arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
    arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
    arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"),
)

fun main() {
    val solution = `거리두기 확인`.getSolution()
    solution.solution(places).forEach {
        println(it)
    }
}
