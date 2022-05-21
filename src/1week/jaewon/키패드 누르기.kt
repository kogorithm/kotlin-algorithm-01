package `1week`.jaewon

import kotlin.math.abs

fun main(){
    print(solution(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2),"left"))
}

fun solution(numbers: IntArray, hand: String): String {
    var answer = ""
    var leftFinger = 10
    var rightFinger = 12

    numbers.forEach { curNum ->
        val number = if(curNum == 0) 11 else curNum
        when(number){
            1,4,7 -> {
                answer += "L"
                leftFinger = number
            }
            3,6,9 -> {
                answer += "R"
                rightFinger = number
            }
            else ->{
                val leftDistance = (abs(number - leftFinger) / 3) + (abs(number - leftFinger) % 3)
                val rightDistance = (abs(number - rightFinger) / 3) + (abs(number - rightFinger) % 3)
                when {
                    leftDistance < rightDistance -> {
                        answer += "L"
                        leftFinger = number
                    }
                    leftDistance > rightDistance -> {
                        answer += "R"
                        rightFinger = number
                    }
                    else -> {
                        when(hand){
                            "right" -> {
                                answer += "R"
                                rightFinger = number }
                            "left" ->{
                                answer += "L"
                                leftFinger = number
                            }
                        }
                    }
                }
            }
        }
    }

    return answer
}

