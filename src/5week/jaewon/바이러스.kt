package `5week`.jaewon

fun main(){
    val n = readln().toInt() //정점의 갯수
    val e = readln().toInt() // 간선의 갯수
    val graph = Array(n+1){ mutableListOf<Int>()}
    repeat(e){
        val (a,b) = readln().split(" ").map{ it.toInt()}
        graph[a].add(b)
        graph[b].add(a)
    }

    dfs(graph,n)
}

fun dfs(graph : Array<MutableList<Int>>,size : Int){
    graph.forEach { it.sortDescending()}
    val visited = Array(size+1){ false }
    val stack = mutableListOf<Int>()

    stack.add(1)
    visited[1] = true
    while (stack.isNotEmpty()){
        val top = stack.removeLast() //pop
        if (!visited[top]){ // 현재 top이 방문했는지 확인
            visited[top] = true
        }
        graph[top].forEach { //현재 top과 인접한 얘들 반복
            if (!visited[it]) {
                stack.add(it)
            }
        }
    }
    println(visited.filter{it}.size-1)
}