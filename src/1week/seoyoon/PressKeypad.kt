import java.lang.Math.abs

class MySolution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var LCur: Int = 10
        var RCur: Int = 12

        for (i in 0 until numbers.size) {
            if (numbers[i] == 0) numbers[i] = 11

            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L"
                LCur = numbers[i]
            }
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R"
                RCur = numbers[i]
            }
            else {
                var LDis = abs(numbers[i] - LCur)/3 + abs(numbers[i] - LCur)%3
                var RDis = abs(numbers[i] - RCur)/3 + abs(numbers[i] - RCur)%3

                if (LDis < RDis) {
                    answer += "L"
                    LCur = numbers[i]
                }
                else if (RDis < LDis) {
                    answer += "R"
                    RCur = numbers[i]
                }
                else {
                    if (hand == "right") {
                        answer += "R"
                        RCur = numbers[i]
                    } else {
                        answer += "L"
                        LCur = numbers[i]
                    }
                }
            }
        }
        return answer
    }
}