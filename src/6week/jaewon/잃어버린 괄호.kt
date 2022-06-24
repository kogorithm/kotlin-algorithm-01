package `6week`.jaewon

fun main(){
    print(readln()
        .split("-")
        .map{it.split("+").map { it.toInt() }.reduce { acc, s -> acc+s }}
        .reduce{total,num -> total-num})
}