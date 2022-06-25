package `6week`.hyunsoo

fun main(){

    // 수식을 입력 받음. - 뒤의 수를 최대로 만들어라.
    val expression = readln()
    // '-' 의 위치
    var minusLoation = -1
    // 연산자들의 위치
    val whereIsOperator = mutableListOf<Int>()
    // 계산이 되어질 수(정답 값)
    var num = 0

    expression.forEachIndexed{index, it ->

        // '-' 의 위치
        if (it == '-') {
            if (minusLoation == -1) minusLoation = index
            whereIsOperator.add(index)
        }
        // '+'의 위치
        if (it == '+') {
            whereIsOperator.add(index)
        }

    }

    // 문자열 파싱된 마지막 인덱스
    var lastIndex = 0
    // 연산자를 분리한 순수 숫자
    var dividedNum = 0

    // 연산자와 숫자들을 분리하는 작업
    whereIsOperator.forEach {  indexForOperator ->

        dividedNum = expression.substring(lastIndex,indexForOperator).toInt()
        lastIndex = indexForOperator+1

        // - 이후의 숫자들은 전부 -로 처리
        if (indexForOperator <= minusLoation || minusLoation == -1){
            num += dividedNum
        } else {
            num -= dividedNum
        }
    }

    // 마지막 연산자뒤에 숫자가 담겨야함.
    dividedNum = expression.substring(lastIndex,expression.length).toInt()
    if (minusLoation == -1){
        num += dividedNum
    } else {
        num -= dividedNum
    }

    println(num)

}


