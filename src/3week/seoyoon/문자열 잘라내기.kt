package `3week`.seoyoon

fun main() {
    val (r, c) = readln().split(" ").map{ it.toInt() }
    val arr = Array(r, {CharArray(c)})
    var ans = 0

    // 문장을 입력받아 배열에 저장
    repeat(r) {
        arr[it] = readln().toCharArray()
    }

    // 저장된 배열의 값으로 세로 문자열 배열 생성
    val word = mutableListOf<String>()
    repeat(c) {
        var tmp = ""
        for (i in 0 until r) {
            tmp += arr[i][it]
        }
        word.add(tmp)
    }

    Loop1@
    for (i in 1 until r) {
        val set = hashSetOf<String>()
        Loop2@
        for (j in 0 until c) {
            var cur = word[j].substring(i)

            // cur가 중복된 문자열이라면 Loop1까지 빠져나오고 break
            if (set.contains(cur)) break@Loop1
            // 중복되지 않았다면 set에 cur 문자열 추가
            else set.add(cur)
        }
        ans++
    }
    println(ans)
}