class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";

        for (char c: my_string.toCharArray()) {
            if (Character.toString(c).equals(alp))
                answer += Character.toUpperCase(c);
            else
                answer += c;
        }

        return answer;
    }
}