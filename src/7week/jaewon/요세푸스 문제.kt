package `7week`.jaewon

fun main(){
    val (n,k) = readln().split(" ").map { it.toInt()}
    val yo = arrayListOf<Int>()
    val answer : ArrayList<Int> = arrayListOf()
    repeat(n){ yo.add(it+1)}

    var count = 1
    while (yo.isNotEmpty()){
        if(count == k){
            answer.add(yo[0])
            count = 1
        }else{
            yo.add(yo[0])
            count++
        }
        yo.removeFirst()
    }

    println(answer.joinToString(", ","<",">"))
}