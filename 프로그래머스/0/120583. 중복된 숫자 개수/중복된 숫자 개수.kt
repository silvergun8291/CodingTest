class Solution {
    fun solution(array: IntArray, n: Int): Int {
        var answer: Int = 0
        
        for (i in array) {
            if (i == n)
                answer++
        }
        
        return answer
    }
}