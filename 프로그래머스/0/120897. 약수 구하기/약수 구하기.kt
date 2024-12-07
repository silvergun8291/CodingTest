class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray = (1..n).filter{n % it == 0}.toIntArray()
        
        return answer
    }
}