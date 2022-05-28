package `2week`.seoyoon

fun main() {
    val numbers = intArrayOf(6, 10, 2)
    var answer = ""
    numbers.sortedWith(Comparator { o1, o2 -> "$o2$o1".compareTo("$o1$o2") })
        .forEach { answer += it }

    if (answer.startsWith("0")) "0" else answer
    println(answer)
}