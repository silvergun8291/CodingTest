class Solution {
    fun solution(my_string: String): Int {
        var answer: Int = 0
        val number: String = my_string.replace("[a-zA-Z]".toRegex(), " ").trim()
        val numberList: List<Int> = if (number == "") listOf(0) else number.split("\\s+".toRegex()).map { it.toInt() }

        answer = numberList.sum()

        return answer
    }
}