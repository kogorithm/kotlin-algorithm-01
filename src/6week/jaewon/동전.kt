package `6week`.jaewon

fun main(){
    var(n,k) = readln().split(" ").map {it.toInt()}
    val coinList = mutableListOf<Int>()
    var answer = 0

    repeat(n){
        coinList.add(readln().toInt())
    }

    coinList.reversed().forEach {
        if(k == 0 ){ return@forEach }
        answer += k/it
        k %= it
    }
    print(answer)
}