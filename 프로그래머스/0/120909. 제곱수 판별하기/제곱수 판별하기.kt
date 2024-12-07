class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        
        for (i in 2 until n) {
            if (i * i == n) {
                answer = 1
                break
            }
            else {
                answer = 2
            }
        }
        
        return answer
    }
}