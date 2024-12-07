class Solution {
    fun solution(array: IntArray): Int {
        var answer: Int = array.sorted()[array.size / 2]
        return answer
    }
}