class Solution {
    fun solution(my_string: String, letter: String): String {
        var answer: String = my_string.filter{it != letter[0]}.toString()
        return answer
    }
}