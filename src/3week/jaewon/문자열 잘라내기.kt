package `3week`.jaewon

fun main(){
    val (r,c) = readln().split(" ").map{it.toInt()}
    val strings = MutableList(r){readln()}
    var count = 0
    val setList = mutableListOf<String>()

    for (i in 0 until strings[0].length){
        val temp = strings.map{it[i]}.joinToString("")
        setList.add(temp)
    }

    for (i in 1 ..r){
        val tempSet = mutableSetOf<String>()
        setList.forEach {
            val temp = it.substring(i-1,r)
            tempSet.add(temp)
        }
        if(tempSet.size == c) {count++} else break
    }
    println(count-1)
}
