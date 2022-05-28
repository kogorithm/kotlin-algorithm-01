package `2week`.seoyoon

fun main() {
    val arr = intArrayOf(6, 10, 2)
    println(solution(arr))
}

fun solution(numbers: IntArray): String {
    var answer = ""
    numbers.sortedWith(Comparator { o1, o2 -> "$o2$o1".compareTo("$o1$o2") })
        .forEach { answer += it }

    return if (answer.startsWith("0")) "0" else answer
}