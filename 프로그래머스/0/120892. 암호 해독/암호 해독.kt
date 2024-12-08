class Solution {
    fun solution(cipher: String, code: Int): String {
        var answer: String = ""
        var index: Int = 0
        
        for (ch in cipher) {
            if ((index+1) % code == 0) {
                answer += ch
            }
            
            index++
        }
        
        return answer
    }
}