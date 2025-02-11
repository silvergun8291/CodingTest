import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> frequencies;

    static int countOdd() {
        int count = 0;

        for (String c : frequencies.keySet()) {
            if (frequencies.get(c) % 2 != 0) {
                count++;
            }
        }

        return count;
    }

    static String findOddAlpha() {
        String alpha = "";

        for (String c : frequencies.keySet()) {
            if (frequencies.get(c) % 2 != 0) {
                alpha = c;
            }
        }

        return alpha;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        frequencies = new TreeMap<>();

        for (int i = 0; i < name.length(); i++) {
            frequencies.put(name.substring(i, i+1), frequencies.getOrDefault(name.substring(i, i+1), 0) + 1);
        }

        // 빈도 분석 결과 개수가 홀수인 알파벳이 두개 이상이면 펠린드롬 생성 불가
        if (countOdd() > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder result;
        String oddAlpha = findOddAlpha();
        StringBuilder first = new StringBuilder();
        StringBuilder last = new StringBuilder();

        for (String s: frequencies.keySet()) {
            if (s.equals(oddAlpha)) {
                int size = frequencies.get(s) - 1;

                for (int i = 0; i < size / 2; i++) {
                    first.append(s);
                }

                for (int i = 0; i < size / 2; i++) {
                    last.insert(0, s);
                }
            }
            else {
                int size = frequencies.get(s);

                for (int i = 0; i < size / 2; i++) {
                    first.append(s);
                }

                for (int i = 0; i < size / 2; i++) {
                    last.insert(0, s);
                }
            }
        }

        result = new StringBuilder(first + oddAlpha + last);
        System.out.println(result);
    }
}
