class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var k: Int = 6

        while (true) {
            if (k % n == 0) {
                answer = k / 6
                break
            }

            k += 6
        }

            return answer
    }
}