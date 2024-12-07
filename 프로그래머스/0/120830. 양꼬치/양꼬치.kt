class Solution {
    fun solution(n: Int, k: Int): Int {
        val drink = k - (n / 10)
        var answer: Int = n * 12000 + drink * 2000
        return answer
    }
}