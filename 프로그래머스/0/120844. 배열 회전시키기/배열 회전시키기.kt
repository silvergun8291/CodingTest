class Solution {
    fun solution(numbers: IntArray, direction: String): IntArray {
        var answer: IntArray = if (direction == "left") {
            numbers.sliceArray(1 until numbers.size) + intArrayOf(numbers[0])
        } else {
            intArrayOf(numbers[numbers.size-1]) + numbers.sliceArray(0 until numbers.size-1)
        }

        return answer
    }
}