package week3.jaewon

fun main(){
    readln().split(" ").map { it.toInt()}
    val numbers = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int,Int>()

    numbers.forEach{ map[it] = (map[it]?:0).plus(1) }

    val frequencyComparator = compareBy<Int> { map[it] }.reversed()
    val indexComparator = frequencyComparator.thenBy{numbers.indexOf(it)}

    println(numbers.sortedWith(indexComparator).joinToString(" "))
}