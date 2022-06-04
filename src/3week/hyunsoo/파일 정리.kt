package `3week`.hyunsoo

fun main(){

    val extentionList = mutableMapOf<String, Int>()
    repeat(readln().toInt()){

        val extension = readln().split(".")[1]

        extentionList.put(extension, extentionList.getOrDefault(extension, 0) + 1)
    }

    extentionList.toSortedMap().forEach{
        println("${it.key} ${it.value}")
    }

}