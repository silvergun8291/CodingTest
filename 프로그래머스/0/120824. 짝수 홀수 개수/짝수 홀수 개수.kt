class Solution {
    fun solution(num_list: IntArray): IntArray {
        val even: IntArray = num_list.filter{it % 2 == 0}.toIntArray()
        val odd: IntArray = num_list.filter{it % 2 != 0}.toIntArray()
        var answer: IntArray = intArrayOf(even.size, odd.size)
        return answer
    }
}