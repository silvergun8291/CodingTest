class Solution {
    fun factorialLoop(n: Int): Int {
        var acc = 1
        for (number in 2..n) {
            acc *= number
        }

        return acc
    }

    fun solution(n: Int): Int {
        var answer: Int = 0

        if (n == 1) {
            answer = 1
        }
        else if (n == 2) {
            answer = 2
        }
        else if (n == 3) {
            answer = 2
        }
        else {
            for (number in 1..n/2) {
                val factorial: Int = factorialLoop(number)

                if (factorial > n)
                    break

                answer = number
            }
        }
        return answer
    }
}