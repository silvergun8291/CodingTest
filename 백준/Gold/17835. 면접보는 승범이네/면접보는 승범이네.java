import java.io.*;
import java.util.*;

public class Main {
    // 우선순위 큐에 들어갈 노드 정보
    static class Node implements Comparable<Node> {
        int index;
        long distance;

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

        int N = Integer.parseInt(st.nextToken());  // 도시 수
        int M = Integer.parseInt(st.nextToken());  // 도로 수
        int K = Integer.parseInt(st.nextToken());  // 면접장 수

        // 그래프: 역방향 간선 저장
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 (b -> a, 비용 c 이지만 역방향으로 저장: a 에서 b 로)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        // 면접장들
        st = new StringTokenizer(br.readLine());
        int[] interview = new int[K];
        for (int i = 0; i < K; i++) {
            interview[i] = Integer.parseInt(st.nextToken());
        }

        // 다익스트라를 위한 거리 배열 (long), 초기값 INF
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 여러 출발점(면접장) 초기화
        for (int t : interview) {
            dist[t] = 0;
            pq.offer(new Node(t, 0L));
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

        // 최장 거리 및 해당 도시 찾기
        long maxDist = -1;
        int city = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] > maxDist || (dist[i] == maxDist && i < city)) {
                maxDist = dist[i];
                city = i;
            }
        }

        // 결과 출력
        System.out.println(city);
        System.out.println(maxDist);
    }
}
