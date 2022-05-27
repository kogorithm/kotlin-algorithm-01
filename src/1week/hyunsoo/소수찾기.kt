import kotlin.math.sqrt
class Solution {
    val numbersList = mutableListOf<Int>()
    val checkedVisit = BooleanArray(7, { false })
    val resultList = mutableListOf<Int>()
    val ansList = mutableListOf<Int>()
    var numOfString =""
    fun solution(numbers: String): Int {

        numbers.forEach {
            numbersList.add(it -'0')
        }
        for (depth in 1 .. numbersList.size){
            getPermutation(0, depth)
        }

        return ansList.size
    }

    // 순열 구하기
    fun getPermutation(cnt : Int, depth : Int){
        if (cnt == depth){
            numOfString = ""
            resultList.forEach {
                numOfString += it.toString()
            }
            if (!(numOfString.toInt() in ansList) && numOfString != "") {
                if(isPrime(numOfString.toInt())) ansList.add(numOfString.toInt())
            }

            return
        }
        for (i in 0 until numbersList.size){
            if (checkedVisit[i] == false){
                checkedVisit[i] = true
                resultList.add(numbersList[i])
                getPermutation(cnt+1, depth)
                resultList.removeAt(resultList.lastIndex)
                checkedVisit[i] = false
            }
        }
    }

    // 소수임을 판별한다.
    fun isPrime(num : Int) : Boolean{
        // 2를 제외한 모든 짝수는 소수가 아님
        if (num != 2 && num % 2 == 0 || num == 1) return false
        for (no in 2 .. sqrt(num.toFloat()).toInt() ){
            if (num % no == 0) return false
        }

        return true
    }
}