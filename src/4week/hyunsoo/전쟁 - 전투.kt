package `4week`.hyunsoo

fun main() {

    // 전쟁터의 크기
    val (n, m) = readln().split(" ").map { it.toInt() }
    // 전쟁터 정보
    val battleGround = mutableListOf<MutableList<Char>>()
    // 상대팀 파워
    var enemyPower = 0
    // 우리팀 파워
    var myPower = 0
    // 인접한 병사들의 수
    var cntGroup = 0

    // 전쟁터 정보 입력받기
    repeat(m) {
        battleGround.add(readln().toMutableList())
    }

    for (x in 0 until m) {
        for (y in 0 until n) {
            // 아군일 때
            if (battleGround[x][y] == 'W') {
                cntGroup = bfs(x, y, battleGround, 'W')
                myPower += cntGroup * cntGroup
                // 적군일 때
            } else {
                cntGroup = bfs(x, y, battleGround, 'B')
                enemyPower += cntGroup * cntGroup
            }
        }
    }

    println("$myPower $enemyPower")
}

fun bfs(x: Int, y: Int, battleGround: MutableList<MutableList<Char>>, start: Char): Int {
    var ans = 0
    val h = battleGround.size
    val w = battleGround[0].size

    // 범위를 넘어가면 탐색 종료
    if (x < 0 || x >= h || y < 0 || y >= w) return 0

    // 이미 탐색한 곳이라면 탐색 종료
    // - 'C'는 이미 확인한 곳을 뜻함.
    if (battleGround[x][y] == 'C') return 0
    // 우리팀 병사(W)위력의 합을 계산할 때 탐색한 지점이 적국 병사(B)라면
    if (start == 'W' && battleGround[x][y] == 'B') return 0
    // 적국 병사(B)위력의 합을 계산할 때 탐색한 지점이 우리팀 병사(W)라면
    if (start == 'B' && battleGround[x][y] == 'W') return 0

    // 확인처리
    battleGround[x][y] = 'C'
    ans++

    // 상하 좌우 탐색
    ans += bfs(x + 1, y, battleGround, start)
    ans += bfs(x, y + 1, battleGround, start)
    ans += bfs(x - 1, y, battleGround, start)
    ans += bfs(x, y - 1, battleGround, start)

    return ans

}

