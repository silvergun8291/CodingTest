class Solution {
    fun solution(array: IntArray): Int {
        var answer: Int = array.map { it.toString() }.sumOf { it.toList().count { it == '7' } }

        return answer
    }
}