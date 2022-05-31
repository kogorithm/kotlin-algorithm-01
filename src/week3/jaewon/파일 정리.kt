package week3.jaewon

fun main(){
    val n = readln().toInt()
    val files = mutableListOf<String>()
    while (true){
        if(files.size == n) break
        val file = readln()
        if(file != ""){
            files.add(file)
        }
    }

    val new = files.groupBy {
        it.split(".")[1]
    }.toSortedMap()

    println(new.toString())
    for (( key, value ) in new ){
        println("$key ${value.size}")
    }
}
