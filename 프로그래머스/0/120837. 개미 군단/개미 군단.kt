class Solution {
    fun solution(hp: Int): Int {
        var answer: Int = 0
        var hp: Int = hp
        
        if (hp < 3) {
            answer = hp
        }
        else if (hp == 3) {
            answer = 1
        }
        else if (hp == 4) {
            answer = 2
        }
        else if (hp == 5) {
            answer = 1
        }
        else {
            while (hp != 0) {
                if (hp >= 5) {
                    answer += hp / 5
                    hp = hp % 5
                }
                else if (hp >= 3) {
                    answer += hp / 3
                    hp = hp % 3
                }
                else {
                    answer += hp
                    break
                }
            }
        }
        
        return answer
    }
}