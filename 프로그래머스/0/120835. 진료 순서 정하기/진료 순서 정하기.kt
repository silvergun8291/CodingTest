class Solution {
    fun solution(emergency: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        val sortedMap = emergency.sortedDescending()
            .withIndex()
            .associate { it.index + 1 to it.value }

        for (e in emergency) {
            for ((key, value) in sortedMap) {
                if (e == value) {
                    answer += key
                }
            }
        }

        return answer
    }
}