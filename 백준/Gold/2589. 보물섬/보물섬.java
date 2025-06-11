import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L, W;
        char [][] map;
        int [] dy = {-1, 1 ,0, 0};
        int [] dx = {0, 0, -1, 1};

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[L][W];

        for (int i = 0; i < L; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = 0;

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                boolean[][] visited = new boolean[L][W];
                int max = 0;

                if (map[i][j] == 'L') {
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int y = cur[0] + dy[d];
                            int x = cur[1] + dx[d];

                            if (y >= 0 && y < L && x >= 0 && x < W && !visited[y][x] && map[y][x] == 'L') {
                                visited[y][x] = true;
                                queue.add(new int[]{y, x, cur[2] + 1});
                            }
                        }

                        max = Math.max(max, cur[2]);
                    }
                }

                result = Math.max(result, max);
            }
        }

        System.out.println(result);
    }
}