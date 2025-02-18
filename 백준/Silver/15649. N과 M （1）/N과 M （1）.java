import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int [] p;
    static int [] nums;
    static boolean [] visited;
    static StringBuilder result;

    static void dfs(int depth) {
        if (depth == M) {
            for (int num : nums) {
                result.append(num).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            nums[depth] = p[i];

            dfs(depth + 1);

            nums[depth] = 0;
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N];
        nums = new int[M];
        visited = new boolean[N];
        result = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            p[i-1] = i;
        }

        dfs(0);

        System.out.println(result);
    }
}
