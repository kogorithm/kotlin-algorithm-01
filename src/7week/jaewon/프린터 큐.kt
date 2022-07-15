package `7week`.jaewon

/**
 * while문으로 반복
 * 현재 중요도가 제일 높은지 확인
 * 높다면 -> 제거, count ++ - ( count default = 1 )
 *       m과 같다면 print하고 종료.
 * 아니라면 맨 뒤로 보내기
 */

fun main(){
    repeat(readln().toInt()){
        val (_,m) = readln().split(" ").map{it.toInt()}
        val temp = readln().split(" ").map { it.toInt()}
        val paper = mutableListOf<Pair<Int,Int>>()
        temp.forEachIndexed { index, i -> paper.add(Pair(i,index))  }

        var count = 1
        while(true){
            val top = paper.maxOf{ it.first }
            if(paper[0].first == top){
                if(paper[0].second == m){
                    println(count)
                    break
                }
                count++
            }else{
                paper.add(paper[0])
            }
            paper.removeAt(0)
        }
    }
}