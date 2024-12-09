class Solution {
    fun solution(my_string: String): String {
        var answer: String = ""
        
        for (ch in my_string) {
            if ((ch.toString() in answer) == false) {
                answer += ch
            }
        }
        
        return answer
    }
}