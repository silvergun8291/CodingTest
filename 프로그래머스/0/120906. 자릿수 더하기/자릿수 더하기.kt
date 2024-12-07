class Solution {
    fun solution(n: Int): Int {
        var answer: Int = n.toString().map{it.digitToInt()}.sum()
        return answer
    }
}