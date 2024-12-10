class Solution {
    fun solution(letter: String): String {
        val morse = mapOf(
            ".-" to "a", "-..." to "b", "-.-." to "c", "-.." to "d", "." to "e", "..-." to "f",
            "--." to "g", "...." to "h", ".." to "i", ".---" to "j", "-.-" to "k", ".-.." to "l",
            "--" to "m", "-." to "n", "---" to "o", ".--." to "p", "--.-" to "q", ".-." to "r",
            "..." to "s", "-" to "t", "..-" to "u", "...-" to "v", ".--" to "w", "-..-" to "x",
            "-.--" to "y", "--.." to "z"
        )

        val answer: String = letter.split(" ")
            .map { morse[it] ?: "" }
            .joinToString("")

        return answer
    }
}