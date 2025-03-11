import java.io.*;
import java.util.*;

public class Main {
    static int M, N;    // M: 세로, N: 가로
    static int [][] board;
    static boolean [][] visited;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};

    static int bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for (int d = 0; d < 4; d++) {
                int nextY = curY + dy[d];
                int nextX = curX + dx[d];

                if (nextY >= 0 && nextY < M && nextX >= 0 && nextX < N && !visited[nextY][nextX] && board[nextY][nextX] == 0) {
                    queue.add(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] == 0) {
                    areas.add(bfs(i, j));
                }
            }
        }

        Collections.sort(areas);

        sb.append(areas.size()).append("\n");
        for (int area : areas) {
            sb.append(area ).append(" ");
        }

        System.out.println(sb);
    }
}