package `4week`.hyunsoo


class `바이러스`(){
    lateinit var visited: BooleanArray
    lateinit var netWork: Array<MutableList<Int>>
    var ans = 0
    fun main() {

        // 컴푸터의 수
        val cntOfCom = readln().toInt()
        // 컴퓨터 쌍의 수
        val cntOfLine = readln().toInt()

        netWork = Array(cntOfCom + 1, { mutableListOf() })
        visited = BooleanArray(cntOfCom + 1, { false })

        repeat(cntOfLine) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            netWork[a].add(b)
            netWork[b].add(a)
        }

        dfs(1)
        println(ans)

    }

    fun dfs(start: Int) {
        visited[start] = true
        for (connectedCom in netWork[start]) {
            if (visited[connectedCom] == false) {
                visited[connectedCom] == true
                ans += 1
                dfs(connectedCom)
            }
        }
    }
}