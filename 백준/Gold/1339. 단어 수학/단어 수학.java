import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] words = new String[N];
        int [][] alpha = new int[26][2];

        int A = 'A';
        for (int i = 0; i < 26; i++) {
            alpha[i][0] = A++;
        }

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                int weight = (int) Math.pow(10, word.length() - i - 1);
                alpha[c - 'A'][1] += weight;
            }
        }

        Arrays.sort(alpha, (o1, o2) -> o2[1] - o1[1]);

        Map<Character, Integer> map = new HashMap<>();
        int idx = 9;
        for (int i = 0; i < 26; i++) {
            if (alpha[i][1] != 0) {
                map.put((char)alpha[i][0], idx--);
            }
        }

        int sum = 0;

        for (String word: words) {
            StringBuilder number = new StringBuilder();

            for (char c: word.toCharArray()) {
                number.append(map.get(c));
            }

            sum += Integer.parseInt(number.toString());
        }

        System.out.println(sum);
    }
}