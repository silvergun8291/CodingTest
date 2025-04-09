import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer> [] friends;
    static boolean[] visited;
    static boolean found;

    static void dfs(int no, int cnt) {
        if (cnt == 4) {
            found = true;
            return;
        }

        visited[no] = true;

        for (int n : friends[no]) {
            if (visited[n]) continue;

            visited[n] = true;
            dfs(n, cnt + 1);
            visited[n] = false;

            if (found) return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friends = new ArrayList[N];
        visited = new boolean[N];
        found = false;

        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a].add(b);
            friends[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
            visited = new boolean[N];

            if (found) break;
        }

        System.out.println(found ? 1 : 0);
    }
}
