val sizeAndCnt = readln().split(" ").map { it.toInt() }
val num1 = readln().split(" ").map { it.toInt() }
val result1 = mutableListOf<Int>()
var ans1 = 0
fun main() {

    for (depth in 0 .. num.size){
        combination(0, depth, 0)
    }

    if(sizeAndCnt[1] == 0) ans1 -= 1
    println(ans1)

}

fun combination(cnt : Int, depth: Int, beginwith : Int){
    if (cnt == depth){
        if (result.sum() == sizeAndCnt[1]) ans1++
        return
    }
    for (cur in beginwith until num.size){
        result.add(num[cur])
        combination(cnt+1, depth, cur +  1)
        result.removeAt(result.lastIndex)
    }
}