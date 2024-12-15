class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        val number = s.split(" ")
        var prev: Int = 0
        
        for (n in number) {
            if (n != "Z") {
                val tmp = n.toInt()
                answer += tmp
                prev = tmp
            }
            else {
                answer -= prev
            }
        }
        return answer
    }
}