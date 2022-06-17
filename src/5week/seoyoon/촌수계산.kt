package `5week`.seoyoon

var levelGraph = arrayOf<MutableList<Int>>()
var levelVisited = booleanArrayOf()
var isFind = false

fun main() {
    val n = readln().toInt()
    val (a, b) = readln().split(" ").map{ it.toInt() }
    val m = readln().toInt()

    levelGraph = Array(n + 1){ mutableListOf() }
    levelVisited = BooleanArray(n + 1)

    repeat(m) {
        val (x, y) = readln().split(" ").map{ it.toInt() }
        levelGraph[x].add(y)
        levelGraph[y].add(x)
    }

    DFS(a, b,1)
    if (!isFind) println(-1)
}

fun DFS(start : Int, end : Int, level : Int) {
    levelVisited[start] = true

    for (i in levelGraph[start]) {
        if (!levelVisited[i]) {
            if (i == end) {
                isFind = true
                return println(level)
            }
            DFS(i, end, level+1)
        }
    }
}