import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] word = br.readLine().toCharArray();
        char [] word2 = br.readLine().toCharArray();

        Arrays.sort(word);
        Arrays.sort(word2);

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // 첫 번째 문자열 빈도 수 기록
        for (char c : word) {
            freq1[c - 'a']++;
        }

        // 두 번째 문자열 빈도 수 기록
        for (char c : word2) {
            freq2[c - 'a']++;
        }

        // 공통 문자 개수 계산
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.min(freq1[i], freq2[i]);
        }

        int a = (word.length - count);
        int b = (word2.length - count);

        int result = a + b;
        System.out.println(result);
    }
}
