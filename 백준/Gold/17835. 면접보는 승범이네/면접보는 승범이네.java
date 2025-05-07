import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int index;
        long distance;         // long으로 변경

        public Node(int index, long distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.distance, o.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        // 단방향 간선 역추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(v).add(new Node(u, c));
        }

        st = new StringTokenizer(br.readLine());
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 다중 출발점(면접장) 등록
        for (int i = 0; i < K; i++) {
            int t = Integer.parseInt(st.nextToken());
            dist[t] = 0;
            pq.offer(new Node(t, 0));
        }

        // 다익스트라
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.distance > dist[cur.index]) continue;
            for (Node nxt : graph.get(cur.index)) {
                long nd = cur.distance + nxt.distance;
                if (nd < dist[nxt.index]) {
                    dist[nxt.index] = nd;
                    pq.offer(new Node(nxt.index, nd));
                }
            }
        }

        // 최장 거리·도시 찾기
        long maxDist = -1;
        int city = 1;            // 1로 초기화해도 OK
        for (int i = 1; i <= N; i++) {
            if (dist[i] > maxDist || (dist[i] == maxDist && i < city)) {
                maxDist = dist[i];
                city = i;
            }
        }

        System.out.println(city);
        System.out.println(maxDist);
    }
}