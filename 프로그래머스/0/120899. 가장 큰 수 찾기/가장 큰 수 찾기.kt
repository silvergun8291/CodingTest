class Solution {
    fun solution(array: IntArray): IntArray {
        val max_value: Int = array.maxOf {it}
        val index: Int = array.indexOf(max_value)
        var answer: IntArray = intArrayOf(max_value, index)
        return answer
    }
}