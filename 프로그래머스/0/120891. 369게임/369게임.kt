class Solution {
    fun solution(order: Int): Int {
        var answer: Int = 0
        var number: String = order.toString()

        for (ch in number) {
            if (ch == '3' || ch == '6' || ch == '9')
                answer++
        }

        return answer
    }
}