class Solution {
    fun solution(rsp: String): String {
        var answer: String = ""
        
        for (ch in rsp) {
            if (ch == '2')
                answer += '0'
            else if (ch == '0')
                answer += '5'
            else
                answer += '2'
        }
        
        return answer
    }
}