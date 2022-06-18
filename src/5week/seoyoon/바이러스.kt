package `5week`.seoyoon

var graph = arrayOf<MutableList<Int>>()
var visited = booleanArrayOf()
var ans = 0

fun main() {
    val com = readln().toInt()      // 컴퓨터의 수
    val pair = readln().toInt()     // 연결되어 있는 컴퓨터 쌍

    // 컴퓨터가 1부터 시작하기 때문에 com + 1
    graph = Array(com + 1) { mutableListOf() }
    visited = BooleanArray(com + 1)

    repeat(pair) {
        val (x, y) = readln().split(" ").map{ it.toInt() }
        graph[x].add(y)
        graph[y].add(x)
    }

    DFS(1)
    System.out.println(ans)
}

fun DFS(n : Int) {
    visited[n] = true

    for (i in graph[n]) {
        if (!visited[i]) {
            ans++
            DFS(i)
        }
    }
}