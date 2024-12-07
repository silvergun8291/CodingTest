class Solution {
    fun solution(slice: Int, n: Int): Int {
        var answer: Int = 0
        
        if (n % slice > 0) {
            answer = n / slice + 1
        }
        else {
            answer = n / slice
        }
        
        return answer
    }
}