package `3week`.jaewon

fun main(){
    val (r,c) = readln().split(" ").map{it.toInt()}
    val strings = Array(r){readln()}.toMutableList()
    var count = 0

    while (strings.size != 0){
        val tempSet = mutableSetOf<String>()
        for (i in 0 until strings[0].length){
            val temp = strings.map{it[i]}.joinToString("")
            tempSet.add(temp)
        }
        if(tempSet.size == c) {
            strings.removeAt(0)
            count++
        }else break
    }
    println(count-1)
}
