import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int vertex;
        int weight;
        Node next;

        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }

    static class Vertex implements Comparable<Vertex> {
        int no, minDistance;

        public Vertex(int no, int minDistance) {
            this.no = no;
            this.minDistance = minDistance;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.minDistance, o.minDistance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 그래프 생성: b가 감염되면 a가 감염되므로, b->a 방향으로 간선 추가
            Node[] computers = new Node[n + 1];
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                // 컴퓨터 a가 b에 의존하므로, b가 감염되면 a가 감염됨.
                computers[b] = new Node(a, s, computers[b]);
            }

            int[] minTime = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            Arrays.fill(minTime, Integer.MAX_VALUE);
            minTime[c] = 0;

            PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
            pQueue.offer(new Vertex(c, 0));

            int count = 0;
            int maxTime = 0;

            while (!pQueue.isEmpty()) {
                Vertex cur = pQueue.poll();
                if (visited[cur.no]) continue;
                visited[cur.no] = true;
                count++; // 현재 컴퓨터 감염

                // 감염 시간이 가장 큰 값을 기록
                maxTime = Math.max(maxTime, cur.minDistance);

                for (Node next = computers[cur.no]; next != null; next = next.next) {
                    if (!visited[next.vertex] && minTime[next.vertex] > cur.minDistance + next.weight) {
                        minTime[next.vertex] = cur.minDistance + next.weight;
                        pQueue.offer(new Vertex(next.vertex, minTime[next.vertex]));
                    }
                }
            }

            sb.append(count).append(" ").append(maxTime).append("\n");
        }
        System.out.print(sb);
    }
}
