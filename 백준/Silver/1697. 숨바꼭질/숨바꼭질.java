import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    static int minTime;
    static int target;

    static void bfs(int position) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(position);
        visited[position] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == target) {
                minTime = visited[cur];
                return;
            }

            int [] next = {cur-1, cur+1, cur*2};

            for (int i : next) {
                if (i >= 0 && i < 100001 && visited[i] == -1) {
                    visited[i] = visited[cur] + 1;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        Arrays.fill(visited, -1);
        minTime = Integer.MAX_VALUE;

        bfs(N);
        System.out.println(minTime);
    }
}
