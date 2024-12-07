class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray = (1..n).filter{it % 2 != 0}.toIntArray()
        return answer
    }
}