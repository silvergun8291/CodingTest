import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static StringBuilder result = new StringBuilder();
    static int check;

    public static void dfs(int depth, int[] current) {
        if (depth == M) {
            boolean asc = true;
            int prev = 0;

            for (int i = 0; i < M; i++) {
                if (prev > current[i]) {
                    asc = false;
                    break;
                }

                prev = current[i];
            }

            if (asc) {
                for (int i = 0; i < M; i++) {
                    result.append(current[i]).append(" ");
                }
                check = current[0];
                result.append("\n");
            }

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && i > check) {
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

        if (N == M) {
            for (int i = 1; i <= N; i++)
                System.out.print(i + " ");
            return;
        }

        visited = new boolean[N + 1];
        dfs(0, new int[M]);

        System.out.print(result);
    }
}
