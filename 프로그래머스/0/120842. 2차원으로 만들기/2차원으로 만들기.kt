class Solution {
    fun solution(num_list: IntArray, n: Int): Array<IntArray> {
        var answer: Array<IntArray> = arrayOf<IntArray>()
        var size: Int = num_list.size / n
        var i: Int = 0
        var j: Int = 0
        
        while (i < size) {
            var tmp: IntArray = num_list.sliceArray(j..(j+n-1))
            answer += tmp
            j += n
            i++
        }
        
        return answer
    }
}