class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 0
        val plus: IntArray = numbers.filter{it > 0}.sortedDescending().toIntArray()
        val minus: IntArray = numbers.filter{it < 0}.sorted().toIntArray()
        
        if (numbers.size == 2) {
            answer = numbers[0] * numbers[1]
        }
        else {
            val plus_max = if (plus.size > 1) plus[0] * plus[1] else 0
            val minus_max = if (minus.size > 1) minus[0] * minus[1] else 0
            answer = maxOf(plus_max, minus_max)
        }

        return answer
    }
}