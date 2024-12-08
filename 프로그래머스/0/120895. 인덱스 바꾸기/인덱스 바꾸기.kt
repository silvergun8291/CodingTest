class Solution {
    fun solution(my_string: String, num1: Int, num2: Int): String {
        var answer: String = ""
        val my_string: CharArray = my_string.toCharArray()
        val first: Char = my_string[num1]
        val second: Char = my_string[num2]
        
        my_string[num2] = first
        my_string[num1] = second
        answer = String(my_string)
        
        return answer
    }
}