package `3week`.jaewon

fun main(){
    val n = readln().toInt()
    val files = Array(n) { readln() }
    val new = files.groupBy { it.split(".")[1] }.toSortedMap()
    
    for (( key, value ) in new ){
        println("$key ${value.size}")
    }
}
