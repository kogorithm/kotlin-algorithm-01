package `3week`.hyunsoo

fun main(){

    val s = readln()
    val substringSet = mutableSetOf<String>()

    for (start in 0 .. s.length){

        for (end in start+1 .. s.length){

            substringSet.add(s.substring(start,end))

        }
    }
    println(substringSet.size)
}


