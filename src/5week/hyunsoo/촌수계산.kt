package `5week`.hyunsoo


class `촌수계산`(){
    lateinit var relation: Array<MutableList<Int>>
    lateinit var visited: BooleanArray
    var ans = -1

    fun main() {
        val n = readln().toInt()
        val (x, y) = readln().split(" ").map { it.toInt() }
        val m = readln().toInt()

        relation = Array(n + 1, { mutableListOf() })
        visited = BooleanArray(n + 1, { false })

        repeat(m) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            relation[a].add(b)
            relation[b].add(a)
        }

        dfs(x, y, 1)
        println(ans)
    }

    fun dfs(start: Int, end: Int, depth: Int) {
        visited[start] = true
        relation[start].forEach { connected ->
            if (connected == end) {
                ans = depth
                return
            }
            if (visited[connected] == false) {
                visited[connected] = true
                dfs(connected, end, depth + 1)
            }
        }
    }
}