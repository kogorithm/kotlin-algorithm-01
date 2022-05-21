package `1week`.dongho.combination

//private fun <T> combination(list: List<T>, num: Int): List<List<T>> {
//    if (num == 1) {
//        return list.map { listOf(it) }
//    }
//    val length = list.size
//    val result = mutableListOf<List<T>>()
//    for (i in 0 until length) {
//        val current = list[i]
//        val combinations = combination(list.subList(i + 1, length), num - 1)
//        val attach = combinations.map { combination ->
//            mutableListOf<T>().run {
//                add(current)
//                addAll(combination)
//                this
//            }
//        }
//        result.addAll(attach)
//    }
//    return result.toList()
//}

fun <T> List<T>.combination(num: Int): List<List<T>> {
    if (num == 1) {
        return map { listOf(it) }
    }
    val length = size
    val result = mutableListOf<List<T>>()
    for (i in 0 until length) {
        val current: T = this[i]
        val combinations = this.subList(i + 1, length).combination(num - 1)
        val attach = combinations.map { combination ->
            mutableListOf<T>(current).run {
                addAll(combination)
                this
            }
        }
        result.addAll(attach)
    }
    return result.toList()
}
