class Solution {
    fun solution(money: Int): IntArray {
        val coffee: Int = money / 5500
        val change: Int = money % 5500
        
        var answer: IntArray = intArrayOf(coffee, change)
        return answer
    }
}