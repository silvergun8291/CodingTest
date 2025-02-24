import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();

        // 0부터 9까지 초기화
        for (int i = 0; i < 10; i++) {
            map.put(i, 0);
        }

        String number = br.readLine();

        // 각 숫자의 빈도를 카운트
        for (char n : number.toCharArray()) {
            int digit = n - '0';
            map.put(digit, map.get(digit) + 1);
        }

        // 6과 9를 합산하고 2로 나눈 올림 값 계산
        int sixNine = map.get(6) + map.get(9);
        int combined = (int) Math.ceil(sixNine / 2.0);

        // 6, 9 제외한 다른 숫자들의 최대 빈도 계산
        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9)
                continue;
            max = Math.max(max, map.get(i));
        }

        max = Math.max(max, combined);
        System.out.println(max);
    }
}