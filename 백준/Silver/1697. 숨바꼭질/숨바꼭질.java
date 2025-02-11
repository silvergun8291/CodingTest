import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    static int bfs(int start, int target) {
        if (start == target) return 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAX + 1];
        int[] time = new int[MAX + 1];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next == target) return time[current] + 1;

                if (next >= 0 && next <= MAX && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    time[next] = time[current] + 1;
                }
            }
        }

        return -1; // 도달할 수 없는 경우 (실제로는 발생하지 않음)
    }
}
