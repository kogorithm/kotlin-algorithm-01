package `5week`.jaewon

fun main(){
    var answer = 0

    while (true){
        val (w,h) = readln().split(" ").map{it.toInt()}
        if(w ==0 && h==0){
            break
        }
        val matrix = Array(h){ mutableListOf<Int>() }
        val visited = Array(h){ Array(w){false}}
        repeat(h){index ->
            matrix[index] = readln().split(" ").map{it.toInt()}.toMutableList()
        }

        matrix.forEachIndexed { i, it ->
            it.forEachIndexed{ j, _ ->
                if(!visited[i][j] && matrix[i][j] ==1){
                    visited[i][j] = true
                    findIsLand(matrix,visited,i,j)
                    answer++
                }
            }
        }
        println(answer)
        answer =0
    }
}

fun findIsLand(matrix : Array<MutableList<Int>>, visited : Array<Array<Boolean>> ,a : Int,b : Int){
    val queue = mutableListOf<Pair<Int,Int>>()
    val dx = intArrayOf(-1,0,1,0,-1,-1,1,1)
    val dy = intArrayOf(0,-1,0,1,-1,1,-1,1)

    queue.add(Pair(a,b)) // 초기위치 큐에 넣기

    while(queue.isNotEmpty()){
        repeat(queue.size){
            val front = queue.removeLast()
            val x = front.first
            val y = front.second
            repeat(8){time ->
                val nx = x+dx[time]
                val ny = y+dy[time]
                if(nx in matrix.indices && ny in 0 until matrix[0].size && matrix[nx][ny] == 1){
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true
                        queue.add(Pair(nx,ny))
                    }
                }
            }
        }
    }

}