import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val ground = mutableListOf<MutableList<Int>>()

    val input = br.readLine().split(" ").map { it.toInt() }
    val col = input[0] // 세로
    val row = input[1] // 가로
    var inven = input[2] // 인벤토리에 있는 블럭의 수
    var timeAndHeight = IntArray(2, {999999999})

    repeat(col){
        val Info = br.readLine().split(" ").map { it.toInt() }.toMutableList()
        ground.add(Info)
    }

    var max = 0
    var min = 999999999
    ground.forEach { col ->
        col.forEach {
            if (it < min) min = it
            if (it > max) max = it
        }
    }
    for (std in min .. max){
        val digAndPut = digAndPut(ground,std,inven)
        if (digAndPut <= timeAndHeight[0]){
            timeAndHeight[0] = digAndPut
            timeAndHeight[1] = std
        }

    }
    bw.write("${timeAndHeight[0]} ${timeAndHeight[1]}")
    bw.flush()
    bw.close()

}
fun digAndPut(ground : MutableList<MutableList<Int>>, std : Int, inven : Int) : Int{
    var time = 0
    // 쓸 수 있는 블록 == 인벤토리에 있는 블록
    var blockCanuse = inven
    for (col in 0 until ground.size){

        for (row in 0 until ground[col].size){
            var cur = ground[col][row]
            if (cur < std){
                time += (std - cur)
                blockCanuse -= (std - cur)
            }
            else if (cur > std){
                time += 2 * (cur - std)
                blockCanuse += (cur - std)
            }
        }
    }
    // 사용한 블록이 쓸 수 있는 블록(캐서 얻은 블록 포함)보다 크다면 불가능 하다는 뜻.
    if (blockCanuse < 0) return 999999999
    return time
}