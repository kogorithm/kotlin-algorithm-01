package `4week`.hyunsoo


var minDay = 99999999
fun main(){
    // . 평지, F 숲 으로만 이동 가능
    // 하루에 k칸 이동 가능. 평지에서 야영 필수.
    // k 이동하지 않아도 야영 가능.

    val grid = arrayOf(
        "..FF",
        "###F",
        "###."
    )

    val k = 4


    val one = cloneGird(grid)
    one[0][1] = 'p'
    val two = cloneGird(grid)
    two[2][2] = 'p'

    grid.forEach {
        println(it)
    }
    one.forEach {
        println(it)
    }
    two.forEach {
        println(it)
    }
}

fun bfs(x: Int, y: Int, grid: MutableList<MutableList<Char>>, day : Int, k: Int) : Int{


    // 야영을 안했다면 탈출
    if (day > k) return 0
    var curDay = day+1

    // 범위를 벗어나면 탐색 종료
    if (x < 0 || x >= grid.size || y < 0 || y >= grid.size) return 0

    // 강 혹은 이미 탐색한 곳이라면 탈출
    if (grid[x][y] == '#') return 0

    // 탐색처리 판정
    grid[x][y] == '#'

    bfs(x+1,y,grid,curDay,k)
    bfs(x,y+1,grid,curDay, k)
    bfs(x-1,y,grid,curDay, k)
    bfs(x,y-1,grid,curDay, k)

    return curDay

}

fun cloneGird(grid: Array<String>): MutableList<MutableList<Char>> {
    var clone = Array<CharArray>(grid.size, { CharArray(grid[0].length, { ' ' }) })

    grid.forEachIndexed { i, width ->
        width.forEachIndexed { j, data ->
            clone[i][j] = data
        }
    }
    return clone.map { it.toMutableList() }.toMutableList()
}