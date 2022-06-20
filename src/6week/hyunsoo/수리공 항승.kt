package `6week`.hyunsoo

fun main() {

    // 물이 새는 곳의 개수 n, 테이프의 길이 l
    val (n, l) = readln().split(" ").map { it.toInt() }

    // 누수된 곳 - 오름차순으로 정렬함.
    val whereLeaked = readln().split(" ").map { it.toInt() }.sorted()

    // 필요한 테이프의 개수
    var needTape = 0

    // 마지막으로 테이프를 붙인 위치
    var lastLocation = 0f

    // 누수된 곳을 forEachIndexed를 사용하여 순차 탐색.
    whereLeaked.forEachIndexed { index, location ->

        // 첫 번째(index == 0 일 때)에는 무조건 테이프를 붙여야함.
        // 테이프 붙임 처리.
        if (index == 0) {
            // 마지막으로 테이프를 붙인 위치는 테이프를 붙인 위치 - 0.5를 해줌.
            lastLocation = location - 0.5f
            // 필요한 테이프 1 증가.
            needTape++
            return@forEachIndexed
        }

        // 테이프 붙임처리
        if ((lastLocation + l) < location) {
            // 마지막으로 테이프를 붙인 위치는 테이프를 붙인 위치 - 0.5를 해줌.
            lastLocation = location - 0.5f
            // 필요한 테이프 1 증가.
            needTape++
        }

    }

    println(needTape)

}