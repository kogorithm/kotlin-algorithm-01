package `1week`.dongho.permutation

//private fun <T> permutation(list: List<T>, num: Int): List<List<T>> {
//    if (num == 1) {
//        return list.map { v: T ->
//            listOf(v)
//        }
//    }
//    val result = mutableListOf<List<T>>()
//    val length = list.size
//    for (i in 0 until length) {
//        val current: T = list[i]
//        val permutations = permutation(
//            mutableListOf<T>().run {
//                addAll(list.subList(0, i))
//                addAll(list.subList(i + 1, length))
//                this
//            },
//            num - 1
//        )
//        val attach = permutations.map { permutation ->
//            mutableListOf(current).run {
//                addAll(permutation)
//                this
//            }
//        }
//        result.addAll(attach)
//    }
//    return result.toList()
//}

fun <T> List<T>.permutation(num: Int): List<List<T>> {
    if (num == 1) {
        return map { v: T ->
            listOf(v)
        }
    }
    val result = mutableListOf<List<T>>()
    val length = size
    for (i in 0 until length) {
        val current: T = this[i]
        val permutations = mutableListOf<T>().let {
            it.addAll(this.subList(0, i))
            it.addAll(this.subList(i + 1, length))
            it
        }.permutation(num - 1)
        val attach = permutations.map { permutation ->
            mutableListOf(current).run {
                addAll(permutation)
                this
            }
        }
        result.addAll(attach)
    }
    return result.toList()
}