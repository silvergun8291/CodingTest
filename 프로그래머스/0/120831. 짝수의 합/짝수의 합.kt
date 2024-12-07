class Solution {
    fun solution(n: Int): Int {
        var answer: Int = (1..n).toList().filter {it % 2 == 0}.sum()
        return answer
    }
}