import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth, int[] current) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(current[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current[depth] = i;
                dfs(depth + 1, current);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        dfs(0, new int[M]);

        System.out.print(sb);
    }
}