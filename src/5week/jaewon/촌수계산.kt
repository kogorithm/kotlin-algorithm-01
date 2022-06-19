package `5week`.jaewon

fun main(){
    val num = readln().toInt()
    val (a,b) = readln().split(" ").map { it.toInt() }
    val m = readln().toInt() //간선의 갯수
    val graph = Array(num+1){ mutableListOf<Int>()}
    repeat(m){
        val(parent,child) = readln().split(" ").map { it.toInt() }
        graph[parent].add(child)
        graph[child].add(parent)
    }
    println( bfs(graph,num,a,b))
}

fun bfs(graph : Array<MutableList<Int>>,size : Int,start : Int, end : Int) : Int{
    graph.forEach { it.sort() }
    val visited = Array(size+1){false}
    val queue = mutableListOf<Pair<Int,Int>>() // first = 들어온 값, second = 현재의 level

    queue.add(Pair(start,0)) // 초기 정점 큐에 추가
    visited[start] = true // 초기 정점 자동 방문
    print("$start ")

    while (queue.isNotEmpty()){ //큐가 완전히 빌 때까지 반복
        val front = queue.removeFirst() // 맨앞 가져오기
        graph[front.first].forEach { // 맨앞에 있는 값과 인접한 얘들 전부 queue에 넣기
            if(it == end){ return front.second+1}
            if (!visited[it]){
                queue.add(Pair(it,front.second+1))
                println("들어간 값 : $it  count : ${queue} ")
                visited[it] = true

            }
        }
    }
    return -1
}