package `4week`.hyunsoo

fun main() {

    while (true) {

        val (w, h) = readln().split(" ").map { it.toInt() }
        if (w == 0 && h == 0) break

        var cntOfIsland = 0

        val map = mutableListOf<MutableList<Int>>()
        repeat(h) {
            map.add(readln().split(" ").map { it.toInt() }.toMutableList())
        }

        for (x in 0 until h) {
            for (y in 0 until w) {
                if (bfs(x, y, w, h, map)) {
                    cntOfIsland++
                }
            }
        }

        println(cntOfIsland)
    }
}

fun bfs(x: Int, y: Int, w: Int, h: Int, map: MutableList<MutableList<Int>>): Boolean {

    // 범위를 벗어나면 탐색 종료
    if (x < 0 || x >= h || y < 0 || y >= w) return false
    // 바다면 탐색 안함.
    if (map[x][y] == 0) return false

    map[x][y] = 0

    bfs(x + 1, y, w, h, map)
    bfs(x + 1, y + 1, w, h, map)
    bfs(x, y + 1, w, h, map)
    bfs(x - 1, y + 1, w, h, map)
    bfs(x - 1, y, w, h, map)
    bfs(x - 1, y - 1, w, h, map)
    bfs(x, y - 1, w, h, map)
    bfs(x + 1, y - 1, w, h, map)

    return true

}
