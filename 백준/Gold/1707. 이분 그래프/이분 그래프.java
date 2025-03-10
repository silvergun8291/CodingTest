import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int[] visited; // 색깔 저장 (0 또는 1)

    static boolean bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = 0; // 시작 노드 색상 지정
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int node : graph.get(cur)) {
                if (visited[node] == -1) { // 방문하지 않은 경우
                    visited[node] = (visited[cur] + 1) % 2; // 현재 노드와 다른 색깔 지정
                    queue.offer(node);
                } else if (visited[node] == visited[cur]) { // 인접한 노드가 같은 색깔이면 이분 그래프가 아님
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < K; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            visited = new int[V + 1];
            Arrays.fill(visited, -1);

            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean isBipartite = true;

            // 모든 노드에 대해 체크 (연결되지 않은 그래프도 체크)
            for (int i = 1; i <= V; i++) {
                if (visited[i] == -1) { 
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            sb.append(isBipartite ? "YES\n" : "NO\n");
        }

        System.out.println(sb);
    }
}
