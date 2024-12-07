class Solution {
    fun solution(my_string: String): String {
        var answer: String = ""
        
        for (ch in my_string) {
            if (ch.isUpperCase()) {
                answer += ch.lowercaseChar()
            }
            else {
                answer += ch.uppercaseChar()
            }
        }
        
        return answer
    }
}