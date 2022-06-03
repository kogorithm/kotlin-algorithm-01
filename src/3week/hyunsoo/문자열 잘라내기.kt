package `3week`.hyunsoo

fun main() {

    val stringList = mutableListOf<String>()
    var count = 0

    val (row, col) = readln().split(" ").map { it.toInt() }

    repeat(row) {
        val string = readln()
        stringList.add(string)
    }

    for (rowIndex in 0..row - 2) {

        val stringSet = mutableSetOf<String>()
        for (colIndex in 0 until col) {

            var newString = ""

            for (Index in rowIndex + 1..row - 1) {
                newString += stringList[Index][colIndex]
            }

            if (stringSet.add(newString) == false) {
                println(count)
                return
            }
        }
        count++
        stringList[rowIndex] = "0"
    }

    println(count)

}