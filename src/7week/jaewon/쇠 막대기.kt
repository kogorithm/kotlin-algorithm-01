package `7week`.jaewon

fun main(){
    val list = readln()
    var stick = 0
    var answer = 0
    var i = 0
    while (i < list.length){
        when(list[i]){
            '(' -> {
                if(list[i+1] == ')'){
                    answer += stick
                    i++
                }else stick++
            }else -> {
                answer++
                stick--
            }
        }
        i++
    }
    println(answer)
}