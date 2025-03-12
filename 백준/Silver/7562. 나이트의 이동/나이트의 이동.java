import java.util.*;
import java.io.*;

public class Main {
    static int I;
    static int [] target;
    static int [][] board;
    static boolean[][] visited;
    static int [] dx = { 1,2,2,1,-1,-2,-2,-1 };
    static int [] dy = { 2,1,-1,-2,-2,-1,1,2 };

    static int bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            if (curY == target[0] && curX == target[1]) {
                return board[curY][curX];
            }

            for (int d = 0; d < 8; d++) {
                int nextY = curY + dy[d];
                int nextX = curX + dx[d];

                if (nextY >= 0 && nextY < I && nextX >= 0 && nextX < I && !visited[nextY][nextX]) {
                    queue.add(new int[]{nextY,nextX});
                    visited[nextY][nextX] = true;
                    board[nextY][nextX] = board[curY][curX] + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            I = Integer.parseInt(br.readLine());

            board = new int[I][I];
            visited = new boolean[I][I];
            target = new int[2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            target[0] = Integer.parseInt(st.nextToken());
            target[1] = Integer.parseInt(st.nextToken());

            int move = bfs(y, x);

            sb.append(move).append("\n");
        }

        System.out.println(sb);
    }
}
