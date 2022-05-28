package `2week`.hyunsoo

// 버블정렬 사용
fun main() {
    var ans = 0

    readln().toInt()
    val timeList = readln().split(" ").map { it.toInt() }.toIntArray()

    // implement bubble sort
    for (i in 0 until timeList.size){
        var min = timeList[i]
        var minIndex = i
        for (j in i until timeList.size){
            if (timeList[j] < min){
                min = timeList[j]
                minIndex = j
            }
        }
        val temp = timeList[i]
        timeList[i] = min
        timeList[minIndex] = temp
    }

    for (index in 0 until timeList.size) {
        for (time in 0..index) {
            ans += timeList[time]
        }
    }

    println(ans)

}

// sorted() 사용
//fun main() {
//    var ans = 0
//
//    readln().toInt()
//    val timeList = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
//
//    for (index in 0 until timeList.size) {
//        for (time in 0..index) {
//            ans += timeList[time]
//        }
//    }
//
//    println(ans)
//
//}