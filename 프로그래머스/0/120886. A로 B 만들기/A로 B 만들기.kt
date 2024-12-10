class Solution {
    fun solution(before: String, after: String): Int {
        var answer: Int = if (before.toList().sorted() == after.toList().sorted()) 1 else 0

        return answer
    }
}