package `7week`.hyunsoo
import java.util.PriorityQueue

fun main() {

    val gift = PriorityQueue<Int>(reverseOrder())

    val n = readln().toInt()

    repeat(n) {

        val command = readln()

        // 입력이 0이라면 아이에게 준 선물의 가치 출력
        if (command == "0") {

            // 줄 선물이 없다면
            if (gift.isEmpty()) println(-1)
            // 선물을 주었다면
            else println(gift.poll())

        } else {
            // 선물의 가치들을 gift에 입력
            // 왜 trim()을 사용하지 않으면 NumberFormat 오류가 발생하는지 모르겠음
            command.trim().split(" ")
                .filterIndexed { index, s -> index > 0 }
                .map { it.toInt() }
                .forEach {
                    gift.add(it)
                }
        }

    }
}

