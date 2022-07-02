package `7week`.dongho

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val printerQueue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    val N = br.readLine().toInt()
    for (i in 0 until N) {
        val select = br.readLine().split(" ")[1].toInt()
        val docList: List<Pair<Int, Int>> = br.readLine().split(" ").mapIndexed { index, v -> Pair(v.toInt(), index) }
        printerQueue.addAll(docList)

        var printCnt = 0
        var check: Boolean
        var print: Pair<Int, Int>
        do {
            check = true
            print = printerQueue.poll()
            for (afterPrint in printerQueue) {
                if (afterPrint.first > print.first) {
                    check = false
                    break
                }
            }
            if (check) {
                printCnt++
            } else {
                printerQueue.add(print)
            }
        } while (!printerQueue.isEmpty() && !(check && print.second === select))
        
        bw.write("$printCnt\n")
        printerQueue.clear()
    }
    bw.flush()
    bw.close()
}