import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] forest;
    static int[][] dp;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int dfs(int y, int x) {
        if (dp[y][x] != 0) {
            return dp[y][x];
        }

        dp[y][x] = 1;

        for (int d = 0; d < 4; d++) {
            int nextY = y + dy[d];
            int nextX = x + dx[d];

            if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < N && forest[nextY][nextX] > forest[y][x]) {
                dp[y][x] = Math.max(dp[y][x], dfs(nextY, nextX) + 1);
            }
        }

        return dp[y][x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        forest = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }

        System.out.println(result);
    }
}