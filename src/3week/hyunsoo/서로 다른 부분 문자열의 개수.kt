package `3week`.hyunsoo

class `서로 다른 부분 문자열의 개수` {
    companion object {
        fun getThis() = `서로 다른 부분 문자열의 개수`()
    }

    var s = readln().toList()
    val tempList = mutableListOf<Char>()
    val answerList = mutableSetOf<String>()

    fun combination(cnt : Int, depth : Int, beginWith : Int){
        if (cnt == depth){
            val tempString = tempList.toString()
            answerList.add(tempString)
        }
        for (cur in beginWith until  s.size){
            tempList.add(s[cur])
            combination(cnt+1,depth,cur+1)
            tempList.removeAt(tempList.lastIndex)
        }

    }

}
fun main() {
    val temp = `서로 다른 부분 문자열의 개수`.getThis()

    for (no in 1 until temp.s.size){
       temp.combination(no,temp.s.size,0)
    }
    print(temp.answerList.size)

}


