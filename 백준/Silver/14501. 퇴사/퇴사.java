import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [][] plan = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            plan[i][0] = Integer.parseInt(st.nextToken());
            plan[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+2];

        for (int i = N; i >= 1; i--) {
            if (i + plan[i][0] > N+1) // 상담이 퇴사일을 넘어가는 경우
                dp[i] = dp[i+1];
            else
                dp[i] = Math.max(dp[i+1], plan[i][1] + dp[i + plan[i][0]]);
        }

        System.out.println(dp[1]);
    }
}
