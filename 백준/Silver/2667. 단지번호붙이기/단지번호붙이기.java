import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int [][] map;
    static boolean [][] visited;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};
    static List<Integer> apart;

    static void bfs(int y, int x) {
        Queue<int []> queue = new ArrayDeque<>();
        queue.add(new int [] {y, x});
        visited[y][x] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int [] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for (int d = 0; d < 4; d++) {
                int nextY = curY + dx[d];
                int nextX = curX + dy[d];

                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < N && !visited[nextY][nextX] && map[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    queue.add(new int [] {nextY, nextX});
                    count++;
                }
            }
        }

        apart.add(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        apart = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char [] row = br.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                map[i][j] = row[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(apart.size());

        Collections.sort(apart);

        for (int n: apart) {
            System.out.println(n);
        }
    }
}