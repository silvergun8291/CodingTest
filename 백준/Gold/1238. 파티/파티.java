import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        int[] answer = new int[N + 1];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            int[] dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(i, 0));

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                int curNode = current.index;
                int curDist = current.distance;

                if (dist[curNode] < curDist) continue;

                for (Node next : graph.get(curNode)) {
                    int cost = curDist + next.distance;

                    if (cost < dist[next.index]) {
                        dist[next.index] = cost;
                        pq.offer(new Node(next.index, cost));
                    }
                }
            }

            answer[i] += dist[X];

            dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[X] = 0;

            pq = new PriorityQueue<>();
            pq.add(new Node(X, 0));

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                int curNode = current.index;
                int curDist = current.distance;

                if (dist[curNode] < curDist) continue;

                for (Node next : graph.get(curNode)) {
                    int cost = curDist + next.distance;

                    if (cost < dist[next.index]) {
                        dist[next.index] = cost;
                        pq.offer(new Node(next.index, cost));
                    }
                }
            }

            answer[i] += dist[i];

            max = Math.max(max, answer[i]);
        }

        System.out.println(max);
    }
}