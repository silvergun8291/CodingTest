import kotlin.math.pow

class Solution {
    fun solution(n: Int, t: Int): Int {
        val base: Double = 2.0
        val answer: Int = n * base.pow(t).toInt()
        return answer
    }
}