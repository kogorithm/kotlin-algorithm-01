package `5week`.seoyoon

var map = arrayOf<IntArray>()
var mapVisited = arrayOf<BooleanArray>()
var mapAns = 0

// 8방향 탐색
val dx = intArrayOf(0, 0, -1, 1, -1, -1, 1, 1)
val dy = intArrayOf(-1, 1, 0, 0, -1, 1, -1, 1)

fun main() {

    while(true) {
        val (w, h) = readln().split(" ").map{ it.toInt() }
        if (w == 0 && h == 0) {
            break
        }

        mapAns = 0
        map = Array(h, { IntArray(w) })
        mapVisited = Array(h, { BooleanArray(w) })

        for (i in 0 until h) {
            map[i] = readln().split(" ").map{ it.toInt() }.toIntArray()
        }

        for (i in 0 until h) {
            for (j in 0 until w) {
                // map에 해당 좌표가 섬이고, 방문하지 않았었다면
                if (map[i][j] == 1 && !mapVisited[i][j]) {
                    mapVisited[i][j] = true
                    DFS(i, j, h, w)
                    mapAns++
                }
            }
        }
        System.out.println(mapAns)
    }
}

fun DFS(col : Int, row : Int, h : Int,  w : Int) {
    for (d in 0 until 8) {
        var newX = row + dx[d]
        var newY = col + dy[d]

        if (newX < 0 || newX >= w || newY < 0 || newY >= h || map[newY][newX] == 0 || mapVisited[newY][newX]) {
            continue
        }
        mapVisited[newY][newX] = true
        DFS(newY, newX, h, w)
    }
}

