class Solution {
    fun solution(box: IntArray, n: Int): Int {
        var answer: Int = 0
        
        val width: Int = box[0] / n
        val height: Int = box[1] / n
        val depth: Int = box[2] / n
        answer = width * height * depth
        
        return answer
    }
}