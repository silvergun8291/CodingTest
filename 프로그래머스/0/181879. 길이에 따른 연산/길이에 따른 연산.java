class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int product = 1;
        
        if (num_list.length >= 11) {
            for (int n: num_list)
                answer += n;
        }
        else {
            for (int n: num_list) {
                product *= n;
            }
            answer = product;
        }
        
        return answer;
    }
}