package `4week`.jaewon

fun solution(periods: IntArray, payments: Array<IntArray>, estimates: IntArray): IntArray {
    val answer= MutableList(2){0}
    val isVIP = MutableList(payments.size-1){false}

    periods.zip(payments).forEachIndexed { index, pair ->
        when(pair.first){
            in 0 until 24 -> { }
            in 24 until 60 -> {
                if(pair.second.sum() >= 900000){ isVIP.add(index,true) }
            }
            else -> {
                if(pair.second.sum() >= 600000){ isVIP.add(index,true) }
            }
        }
    }

    periods.zip(payments).forEachIndexed{index, pair ->
        val newSum = pair.second.drop(1).sum() + estimates[index]
        when(pair.first+1){
            in 0 until 24 -> { }
            in 24 until 60 -> {
                if(isVIP[index] && newSum < 900000){ answer[1]++ }
                if(!isVIP[index] && newSum >= 900000){ answer[0]++ }
            }
            else -> {
                if(isVIP[index] && newSum < 600000){ answer[1]++}
                if(!isVIP[index] && newSum >= 600000){ answer[0]++ }
            }
        }
    }
    return answer.toIntArray()
}

fun main(){

}