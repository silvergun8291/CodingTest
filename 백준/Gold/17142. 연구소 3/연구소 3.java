import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int [][] lab;
    static ArrayList<int[]> virus;
    static int [] select;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int result = Integer.MAX_VALUE;
    static int blank = 0;

    static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int[N][N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = -1;
            }
        }

        for (int index: select) {
            int y = virus.get(index)[0];
            int x = virus.get(index)[1];
            queue.offer(new int[]{y, x});
            visited[y][x] = 0;
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(count == blank){
                return result;
            }
            for (int d = 0; d < 4; d++) {
                int newY = cur[0] + dy[d];
                int newX = cur[1] + dx[d];

                if (newY >= 0 && newY < N && newX >= 0 && newX < N && visited[newY][newX] == -1 && lab[newY][newX] != 1) {
                    if(lab[newY][newX] ==0){
                        ++count;
                    }
                    queue.offer(new int[]{newY, newX});
                    visited[newY][newX] = visited[cur[0]][cur[1]] + 1;
                    result = Math.max(result, visited[newY][newX]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lab[i][j] == 0 && visited[i][j] == -1) return Integer.MAX_VALUE;
            }
        }

        return result;
    }

    static void combination(int start, int cnt) {
        if (cnt == M) {
            int time = bfs();
            result = Math.min(result, time);
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            select[cnt] = i;
            combination(i + 1, cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][N];
        virus = new ArrayList<>();
        select = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if (lab[i][j] == 0)
                    blank++;

                if (lab[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        combination(0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }
    }
}