class Solution {
    fun solution(num: Int, k: Int): Int {
        var answer: Int = if (k.toString() in num.toString()) num.toString().indexOf(k.toString()) + 1 else -1
        return answer
    }
}