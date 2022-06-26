package `6week`.jaewon

fun main(){
    val (_,l) = readln().split(" ").map{it.toInt()}
    val location = readln().split(" ").map{it.toInt()}.sorted()
    var current = 0;
    var cnt = 0;

    location.forEach {
        if(it+0.5 > current){
            cnt++
            current = it+l
        }
    }
    print(cnt)
}