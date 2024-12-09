class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        
        for (i in 4..n) {
            var count: Int = 0
            
            for (j in 1..n) {
                if (i % j == 0) {
                    count++
                }
                
                if (count >= 3) {
                    answer++
                    break
                }
            }
        }
        
        return answer
    }
}