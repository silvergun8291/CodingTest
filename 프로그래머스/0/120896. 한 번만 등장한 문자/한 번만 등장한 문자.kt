class Solution {
    fun solution(s: String): String {
        var answer: String = ""
        val frequencyMap = s.groupingBy { it }
            .eachCount()
            .toList()
            .sortedBy { (_, count) -> count }
            .toMap()
            
        answer = frequencyMap.filter { (_, count) -> count == 1 }
            .keys
            .joinToString("")
            .toList()
            .sorted()
            .joinToString("")

        return answer
    }
}