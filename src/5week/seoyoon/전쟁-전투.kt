package `5week`.seoyoon

var combatMap = arrayOf<CharArray>()
var combatVisited = arrayOf<BooleanArray>()

var wCnt = 0
var bCnt = 0

fun main() {
    val (n, m) = readln().split(" ").map{ it.toInt() }
    combatMap = Array(m, { CharArray(n) })
    combatVisited = Array(m, { BooleanArray(n) })

    repeat(m) {
        combatMap[it] = readln().toCharArray()
    }

    var WSum = 0
    var BSum = 0

    for(i in 0 until m) {
        for(j in 0 until n) {
            if (!combatVisited[i][j]) {
                if (combatMap[i][j] == 'W') {
                    wCnt = 0
                    combatVisited[i][j] = true
                    DFS(m, n, i, j, 'W')
                    WSum += wCnt * wCnt
                }
                else if (combatMap[i][j] == 'B') {
                    bCnt = 0
                    combatVisited[i][j] = true
                    DFS(m, n, i, j, 'B')
                    BSum += bCnt * bCnt
                }
            }
        }
    }
    println("$WSum $BSum")
}

fun DFS(m : Int, n : Int, col : Int, row : Int, ch : Char) {
    // 4방향 탐색
    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(-1, 1, 0, 0)

    if (ch == 'W') {
        wCnt++
    } else {
        bCnt++
    }

    for (d in 0 until 4) {
        var newX = row + dx[d]
        var newY = col + dy[d]

        if (newX < 0 || newX >= n || newY < 0 || newY >= m || combatMap[newY][newX] != ch || combatVisited[newY][newX]) {
            continue
        }

        combatVisited[newY][newX] = true
        DFS(m, n, newY, newX, ch)
    }
}