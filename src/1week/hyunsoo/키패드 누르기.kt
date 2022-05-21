package `1week`.hyunsoo

class Solution {
    var keyPad = arrayOf<IntArray>(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9),
        intArrayOf(99,0,100)
    )
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var lThumb = 99
        var rThumb = 100
        // 1, 4, 7은 왼손 엄지(L)
        // 3, 6, 9는 오른손 엄지(R)
        // 2 5 8 0 은 현재에서 더 가까운거
        // 위치가 같으면 왼손잡이 / 오른손잡이에 따라

        numbers.forEach{ num ->
            // 왼손으로만 누르는 경우
            if (num == 1 || num == 4 || num == 7) {
                answer += "L"
                lThumb = num
                // 오른손으로만 누르는 경우
            } else if(num == 3 || num == 6 || num == 9) {
                answer += "R"
                rThumb = num
                // 더 가까운쪽으로 누르는 경우 - 동일하다면 손잡이인 곳으로
            } else {
                val cur = getLocation(num)
                val lLoc = getLocation(lThumb)
                val rLoc = getLocation(rThumb)
                val diffL = Math.abs(lLoc.second - cur.second) + Math.abs(lLoc.first - cur.first)
                val diffR = Math.abs(rLoc.second - cur.second) + Math.abs(rLoc.first - cur.first)

                // 왼손이 더 가까운 경우
                if(diffL < diffR){
                    answer += "L"
                    lThumb = num
                    // 오른손이 더 가까운 경우
                }else if(diffL > diffR){
                    answer += "R"
                    rThumb = num
                    // 동일한 경우 손잡이로 감.
                } else {
                    // 왼손잡이
                    if(hand == "left"){
                        answer += "L"
                        lThumb = num
                        // 오른손잡이
                    } else {
                        answer += "R"
                        rThumb = num
                    }
                }
            }
        }
        return answer
    }
    fun getLocation(num : Int) : Pair<Int,Int>{
        for(i in 0 until 4){
            for(j in 0 until 3){
                if(num == keyPad[i][j]){
                    return Pair(i,j)
                }
            }
        }
        return Pair(0,0)
    }
}