class Solution {
    fun solution(sides: IntArray): Int {
        var answer: Int = 0
        val sorted_sides: List<Int> = sides.sorted()
        
        answer = if (sorted_sides[0] + sorted_sides[1] > sorted_sides[2]) 1 else 2

        return answer
    }
}