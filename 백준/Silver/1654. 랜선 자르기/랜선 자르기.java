import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lan = new int[K];
        long maxLen = 0;

        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            maxLen = Math.max(maxLen, lan[i]);
        }

        long left = 1;
        long right = maxLen;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            
            long count = 0;
            for (int i = 0; i < K; i++) {
                count += lan[i] / mid;
            }

            if (count >= N) {
                answer = mid;  // 가능한 길이 저장
                left = mid + 1;  // 더 긴 길이 시도
            } else {
                right = mid - 1;  // 더 짧은 길이 시도
            }
        }

        System.out.println(answer);
    }
}
