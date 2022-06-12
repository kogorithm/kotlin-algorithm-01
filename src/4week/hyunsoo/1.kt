package `sk인턴쉽 `

// 보자마자 버블 정렬 생각남.
// 13분만에 컷
fun main(){
    val p = intArrayOf(2,5,3,1,4)

    val mutableListP = p.toMutableList()

    val ans = IntArray(p.size, {0})

    for (i in 0 until p.size){
        var min = mutableListP[i]
        var minIndex = i
        var changed = false

        for (j in i+1 until p.size){
            if (min > mutableListP[j]){
                min = mutableListP[j]
                minIndex = j
                changed = true
            }
        }

        if (changed){
            // 두 개의 위치를 바꿨다는 뜻
            ans[i]++
            ans[minIndex]++

            // 바꾸는 과정
            val temp = min
            mutableListP[minIndex] = mutableListP[i]
            mutableListP[i] = temp
        }

    }

    mutableListP.forEach {
        println(it)
    }
    ans.forEach {
        println(it)
    }
}