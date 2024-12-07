class Solution {
    fun solution(array: IntArray, height: Int): Int {
        var answer: Int = array.filter{it > height}.size
        return answer
    }
}