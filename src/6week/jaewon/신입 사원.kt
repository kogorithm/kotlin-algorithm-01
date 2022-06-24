package `6week`.jaewon

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val result = mutableListOf<Pair<Int,Int>>()
        var answer = 0
        repeat(n){
            val (a,b) = readln().split(" ").map{it.toInt()}
            result.add(Pair(a,b))
        }

        result.forEach { oneResult ->
            if(result.filter{ it.first < oneResult.first }.none{it.second < oneResult.second}){
                answer++
            }
        }
        print(answer)
    }
}