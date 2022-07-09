package `7week`.hyunsoo
import java.util.Stack

fun main(){

    val stack = Stack<Char>()
    val expression = readln()

    var pieces = 0

    expression.forEach{
        // 괄호는 여는 경우는 무조건 stack 에 넣기
        if(it == '(') stack.push(it)

        // 괄호를 닫는 경우는 무조건 pop하기
        else {
            val poped = stack.pop()
            // 만약 pop한 값이 '(' 라면 레이저
            if(poped == '(') {
                pieces += stack.size
            // 만약 pop한 값이 ')' 라면 쇠막대기의 끝
            } else if(poped == ')'){
                pieces++
            }
        }
    }
    println(pieces)
}