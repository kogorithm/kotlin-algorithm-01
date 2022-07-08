package `7week`.hyunsoo

import java.util.*

// 이번 스터디할 때 푼 방식
fun main() {

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val t = readln().toInt()

    repeat(t) {

        // 문서의 개수, 몇 번째로 인쇄되었는지 궁금한 문서
        val (n, m) = readln().split(" ").map { it.toInt() }

        // 문서의 중요도를 입력 받아 (문서의 번호, 문서의 중요도) 순으로 쌍을 만들어줌.
        val documents = readln().split(" ").mapIndexed { index, it -> Pair(index, it.toInt()) }
        var printedCnt = 0

        documents.forEach {
            queue.add(it)
        }

        while (true) {

            val poll = queue.poll()
            var canPrint = true

            // 우선순위가 더 높은게 있으면 다시 뒤로 넣기
            queue.forEach {
                if (poll.second < it.second) canPrint = false
            }

            if (canPrint) {
                printedCnt++
                if (poll.first == m) {
                    println(printedCnt)
                    break
                }
            } else {
                queue.add(poll)
            }
        }
        queue.clear()
    }
}

// 아주 옛날에 풀었던 방식
//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//import java.util.*
//
//fun main() {
//
//    // 빠른 입력
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val bw = BufferedWriter(OutputStreamWriter(System.out))
//    var queue : MutableList<Pair<Int, Boolean>>
//
//    // 테스트 케이스만큼 반복
//    repeat(br.readLine().toInt()) {
//        // MutableList 초기화
//        queue = mutableListOf<Pair<Int, Boolean>>()
//        // [0] 문서의 개수, [1] 몇 번째로 인쇄되었는지 궁금한 문서의 현재 Queue에서의 위치
//        val inform = br.readLine().split(" ")
//        val doc = br.readLine().split(" ")
//
//        // 문서를 순서대로 큐에 넣어줌.
//        doc.forEachIndexed { index, doc ->
//            // 몇 번째로 인쇄되었는지 궁금한 문서라면 true, 아니라면 false와 같이 넣어줌.
//            if (index == inform[1].toInt()) queue.add(Pair(doc.toInt(), true))
//            else queue.add(Pair(doc.toInt(), false))
//        }
//
//        bw.write("${ countPrint(queue) }\n")
//
//    }
//
//    bw.flush()
//    bw.close()
//
//}
//
//fun countPrint(queue: MutableList<Pair<Int, Boolean>>): Int {
//    var cnt = 0;
//
//    while (true in queue.map { it.second }) {
//        // queue에 있는 가장 앞에있는 문서의 우선순위가 가장 높은게 아니라면
//        if (queue.get(0).first != Collections.max(queue.map { it.first })) {
//            queue.add(Pair(queue.get(0).first, queue.get(0).second))
//            queue.removeAt(0)
//        } else if (queue.get(0).first == Collections.max(queue.map { it.first })) {
//            cnt++
//            queue.removeAt(0)
//        }
//    }
//
//    return cnt
//}