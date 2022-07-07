package `7week`.jaewon

import java.util.Stack

/**
 * 1부터 n까지 반복하면서 스택에 넣고,
 * 맨 위의 값이 만들어야 하는 값과 같다면 빼고, 아니면 다음 걸 넣어준다.
 */

fun main(){
    val n = readln().toInt()
    val willMake = arrayListOf<Int>()
    val stack = Stack<Int>()
    val answer = arrayListOf<String>()
    repeat(n){ willMake.add(readln().toInt()) }

    var cnt = 1
    while (willMake.isNotEmpty()){
        if (cnt > n+1){
            println("NO")
            return
        }
        if(stack.isNotEmpty() && stack.peek() == willMake[0]){
            answer.add("-")
            stack.pop()
            willMake.removeFirst()
        }else{
            answer.add("+")
            stack.push(cnt)
            cnt++
        }
    }
    println(answer.joinToString("\n"))
}