import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char [][] picture;
    static boolean [][] visited;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};

    static void bfs(int y, int x, char color) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int [] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for (int d = 0; d < 4; d++) {
                int nextY = curY + dy[d];
                int nextX = curX + dx[d];

                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < N
                        && !visited[nextY][nextX] && color == picture[nextY][nextX]) {
                    queue.add(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                }
            }
        }
    }

    static void convertPicture() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (picture[y][x] == 'R' || picture[y][x] == 'G') {
                    picture[y][x] = 'T';
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            picture[i] = row;
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, picture[i][j]);
                    count++;
                }
            }
        }

        sb.append(count).append(" ");

        convertPicture();

        visited = new boolean[N][N];
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, picture[i][j]);
                    count++;
                }
            }
        }

        sb.append(count);

        System.out.println(sb);
    }
}