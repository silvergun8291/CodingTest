import kotlin.math.absoluteValue

class Solution {
    fun solution(array: IntArray, n: Int): Int {
        var answer: Int = 0
        val number: List<Int> = array.map{it-n}.sortedBy { it.absoluteValue }

        if (number.size == 1) {
            answer = number[0] + n
        }
        else {
            answer = if (number[0].absoluteValue != number[1].absoluteValue) {
                number[0] + n
            } else {
                if (number[0] < number[1]) number[0] + n else number[1] + n
            }
        }

        return answer
    }
}