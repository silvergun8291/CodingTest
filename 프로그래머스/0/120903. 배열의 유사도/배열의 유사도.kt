class Solution {
    fun solution(s1: Array<String>, s2: Array<String>): Int {
        var answer: Int = 0
        
        for (ch in s1) {
            if (ch in s2)
                answer++
        }
        
        return answer
    }
}