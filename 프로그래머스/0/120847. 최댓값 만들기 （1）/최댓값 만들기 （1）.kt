class Solution {
    fun solution(numbers: IntArray): Int {
        val sortedNumbers = numbers.sorted().reversed()
        val answer: Int = sortedNumbers[0] * sortedNumbers[1]
        return answer
    }
}