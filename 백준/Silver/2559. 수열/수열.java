import java.io.*;
import java.util.*;

public class Main {
    static int N;   // 수의 개수
    static int K;   // 합의 범위
    static int [] numbers; // 숫자들

    static int getSumRange(int start, int end) {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += numbers[i];
        }

        return sum;
    }

    static int getMaxSum() {
        int maxSum = -100 * N - 1;

        int start = 0;
        int end = start + K - 1;

        while(end < N) {
            maxSum = Math.max(maxSum, getSumRange(start, end));
            start++;
            end = start + K - 1;
        }

        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 수의 개수를 입력받음
        K = Integer.parseInt(st.nextToken());   // 합의 범위를 입력받음
        int maxSum;     // 합의 최대값

        numbers = new int[N];   // 숫자들을 저장할 배열을 생성하여 초기화

        // 숫자들을 입력받아 배열에 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1)
            maxSum = numbers[0];
        else
            maxSum = getMaxSum();

        System.out.println(maxSum);
    }
}