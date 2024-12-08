class Solution {
    fun solution(my_string: String): IntArray {
        var answer: IntArray = my_string
            .filter{it.isDigit()}
            .map{it.toString().toInt()}
            .sorted()
            .toIntArray()
        
        return answer
    }
}