class Solution {
    fun solution(my_string: String): String {
        var answer: String = ""

        for (ch in my_string) {
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                answer += ch
            }
        }

        return answer
    }
}