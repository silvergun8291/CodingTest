import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] sea;
    static int[] shark;
    static int sharkSize;
    static int sharkEat;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};

    static boolean isIn(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }

    static int[] bfs2(int y, int x) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<int[]> candidates = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2]; // 거리
            if (a[0] != b[0]) return a[0] - b[0]; // y
            return a[1] - b[1]; // x
        });

        queue.add(new int[]{y, x, 0});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            int dist = cur[2];

            // 먹이 발견 시 후보 추가
            if (!(curY == y && curX == x)) {
                if (sea[curY][curX] != 0 && sea[curY][curX] < sharkSize) {
                    candidates.add(new int[]{curY, curX, dist});
                }
            }

            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i], nx = curX + dx[i];
                if (!isIn(ny, nx) || visited[ny][nx] || sea[ny][nx] > sharkSize) continue;

                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx, dist + 1});
            }
        }

        return candidates.isEmpty() ? null : candidates.poll();
    }

    // 아기 상어 시뮬레이션 함수
    static void simulate() {
        int time = 0;

        while (true) {
            int y = shark[0];
            int x = shark[1];

            int[] feed = bfs2(y, x);

            if (feed == null) break;

            int feedY = feed[0];
            int feedX = feed[1];
            int distance = feed[2];

            sharkEat++;

            if (sharkEat == sharkSize) {
                sharkSize++;
                sharkEat = 0;
            }

            sea[y][x] = 0;
            sea[feedY][feedX] = 9;

            shark[0] = feedY;
            shark[1] = feedX;

            time += distance;
        }

        System.out.println(time);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sea = new int[N][N];
        shark = new int[2];
        sharkSize = 2;
        sharkEat = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());

                if (sea[i][j] == 9) {
                    shark[0] = i;
                    shark[1] = j;
                }
            }
        }

        simulate();
    }
}