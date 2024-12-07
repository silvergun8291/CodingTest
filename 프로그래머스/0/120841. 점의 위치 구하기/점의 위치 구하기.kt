class Solution {
    fun solution(dot: IntArray): Int {  
        var answer: Int = if (dot[0] > 0 && dot[1] > 0) {
            1
        }
        else if (dot[0] < 0 && dot[1] > 0) {
            2
        }
        else if (dot[0] < 0 && dot[1] < 0) {
            3
        }
        else {
            4
        }
        return answer
    }
}