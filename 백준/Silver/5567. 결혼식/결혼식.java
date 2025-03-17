import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] distance;
    static int N, M;

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            List<Integer> neighbors = graph.get(current);

            for (int neighbor : neighbors) {
                if (visited[neighbor])
                    continue;

                visited[neighbor] = true;
                distance[neighbor] = distance[current] + 1;

                if (distance[neighbor] <= 2) { // 거리 조건: 최대 친구의 친구까지만 탐색
                    queue.offer(neighbor);
                }
            }
        }
    }

    static int getCount() {
        int count = 0;
        for (int i = 2; i <= N; i++) { // 상근이(노드 1)는 제외
            if (distance[i] > 0 && distance[i] <= 2) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        bfs(1); // 상근이의 시작 노드

        int result = getCount();
        System.out.println(result);
    }
}
