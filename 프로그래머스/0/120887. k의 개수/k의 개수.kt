class Solution {
    fun solution(i: Int, j: Int, k: Int): Int {
        var answer: Int = 0
        var number: String = ""
        
        for (k in i..j) {
            number += k.toString()
        }
        
        for (n in number) {
            if (n.digitToInt() == k)
                answer++
        }
        
        return answer
    }
}