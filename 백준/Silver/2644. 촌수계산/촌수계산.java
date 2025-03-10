import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> graph;
    static int [] visited;
    static int [] target;

    static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(target[0]);
        visited[target[0]] = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> nodes = graph.get(cur);

            for (Integer node : nodes) {
                if (visited[node] != -1)
                    continue;

                visited[node] = visited[cur] + 1;

                if (node == target[1]) {
                    System.out.println(visited[node]);
                    return;
                }

                queue.add(node);
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        target = new int[2];
        target[0] = Integer.parseInt(st.nextToken());
        target[1] = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new int[n+1];
        Arrays.fill(visited, -1);

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs();
    }
}
