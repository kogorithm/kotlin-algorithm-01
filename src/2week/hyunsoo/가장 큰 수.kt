package `2week`.hyunsoo

class Solution {

    fun solution(numbers: IntArray): String {
        var answer = ""
        val numbersToString = mutableListOf<String>()

        // 문자열 리스트로
        numbers.forEach {
            numbersToString += it.toString()
        }

        // 길이가 같다면 그냥 비교, 길이가 다르다면 더해서 비교
        // 30, 3 을 예시로 들면 330 이 303보다 큼.
        numbersToString.sortWith(Comparator{first, second ->
            // 다른 분들이 푸신 것을 보면 if문 부분은 필요가 없을 듯.
            if (first.length == second.length)
                second.compareTo(first)
            else
                (second+first).compareTo(first+second)
        })

        numbersToString.forEach {
            answer += it
        }

        // 0, 0, 0, 0 과 같은 경우를 방지하기 위해.
        return if(answer[0] == '0') "0" else answer
    }

}