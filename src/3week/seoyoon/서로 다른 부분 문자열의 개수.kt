package `3week`.seoyoon

fun main() {
    val S = readln()
    var ans = 0

    val set = hashSetOf<String>();
    for (i in 0 until S.length) {
        var tmp = ""
        for(j in i until S.length) {
            tmp += S.substring(j, j+1);
            set.add(tmp)
        }
    }
    ans = set.size
    println(ans)
}