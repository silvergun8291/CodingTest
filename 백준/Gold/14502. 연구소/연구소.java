import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int [][] lab;
    static boolean[][] labVisited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static List<int[]> blank;
    static List<int[]> virus;
    static int [][] wall;
    static int maxSafeArea;
    static boolean [][] visited;

    static void bfs(int [][] newLab) {
        boolean [][] labVisited = new boolean[N][M];
        Queue<int[]> que = new ArrayDeque<>();

        for (int[] v: virus) {
            int y = v[0];
            int x = v[1];

            que.add(v);
            labVisited[y][x] = true;
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curY = cur[0];
            int curX = cur[1];

            for (int d = 0; d < 4; d++) {
                int nextY = curY + dy[d];
                int nextX = curX + dx[d];

                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && !labVisited[nextY][nextX] && newLab[nextY][nextX] == 0) {
                    que.add(new int[]{nextY, nextX});
                    labVisited[nextY][nextX] = true;
                    newLab[nextY][nextX] = 2;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newLab[i][j] == 0) count++;
            }
        }

        maxSafeArea = Math.max(maxSafeArea, count);
    }

    static void bruteforce(int cnt, int target) {
        if (cnt == target) {
            int [][] newLab = new int[N][M];

            for (int y = 0; y < N; y++) {
                if (M >= 0) System.arraycopy(lab[y], 0, newLab[y], 0, M);
            }

            for (int [] w : wall) {
                int y = w[0];
                int x = w[1];

                newLab[y][x] = 1;
            }

            bfs(newLab);

            return;
        }

        for (int[] cur : blank) {
            int curY = cur[0];
            int curX = cur[1];

            if (visited[curY][curX]) continue;

            visited[curY][curX] = true;
            wall[cnt] = cur;
            bruteforce(cnt + 1, target);
            visited[curY][curX] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];
        virus = new ArrayList<>();
        blank = new ArrayList<>();
        wall = new int[3][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if (lab[i][j] == 0) blank.add(new int[]{i, j});
                if (lab[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        visited = new boolean[N][M];
        bruteforce(0, 3);

        System.out.println(maxSafeArea);
    }
}