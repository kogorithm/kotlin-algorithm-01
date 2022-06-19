package `5week`.jaewon

fun main(){
    val answer = Array(2){0}
    val (n,m) = readln().split(" ").map{it.toInt()}
    val matrix = Array(m){ mutableListOf<Int>()}
    val visited = Array(m){ Array(n){false}}
    repeat(m){index ->
        val list = readln().map{ if( it == 'W' ) 1 else 0 }.toMutableList()
        matrix[index] = list
    }
    
    matrix.forEachIndexed { i, it ->
        it.forEachIndexed{ j, _ ->
            if(!visited[i][j] && matrix[i][j] == 1){ //아군
                visited[i][j] = true
                val temp = findOurs(matrix,visited,i,j,1)
                answer[0] += temp*temp
            }
            if(!visited[i][j] && matrix[i][j] == 0){ //적군
                visited[i][j] = true
                val temp = findOurs(matrix,visited,i,j,0)
                answer[1] += temp*temp
            }
        }
    }

    println("${answer[0]} ${answer[1]}")
}

fun findOurs(matrix : Array<MutableList<Int>>, visited : Array<Array<Boolean>> ,a : Int,b : Int, type : Int): Int {
    var cnt = 0
    val queue = mutableListOf<Pair<Int,Int>>()
    val dx = intArrayOf(0,1,0,-1)
    val dy = intArrayOf(1,0,-1,0)

    queue.add(Pair(a,b)) // 초기위치 큐에 넣기

    while(queue.isNotEmpty()){
        repeat(queue.size){
            val front = queue.removeLast()
            val x = front.first
            val y = front.second
            repeat(4){time ->
                val nx = x+dx[time]
                val ny = y+dy[time]
                if(nx in matrix.indices && ny in 0 until matrix[0].size && matrix[nx][ny] == type){
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true
                        queue.add(Pair(nx,ny))
                        cnt++
                    }
                }
            }
        }
    }
    return cnt+1
}