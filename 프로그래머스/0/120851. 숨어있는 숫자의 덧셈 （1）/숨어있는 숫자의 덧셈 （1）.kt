class Solution {
    fun solution(my_string: String): Int {
        var answer: Int = my_string.filter{it.isDigit()}.sumOf { it.digitToInt() }
        
        
        
        return answer
    }
}