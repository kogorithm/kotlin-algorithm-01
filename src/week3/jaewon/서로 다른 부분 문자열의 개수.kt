package week3.jaewon

fun main(){
    val s = readln()
    val set = mutableSetOf<String>()
    for (i in 1 until s.length+1) {
        // i개가 연속된 문자열
        for(j in 0.. s.length -i){
            set.add(s.substring(j,j+i))
        }
    }
    print(set.size)
}
