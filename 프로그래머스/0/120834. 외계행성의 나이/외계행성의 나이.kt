class Solution {
    fun solution(age: Int): String {
        var answer: String = age.toString().map{(it.digitToInt() + 97).toChar()}.joinToString("")

        return answer
    }
}