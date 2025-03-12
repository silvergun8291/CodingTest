import java.io.*;
import java.util.*;

public class Main {
    static int L, R, C;
    static char[][][] map;
    static int[][][] visited;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static class Node {
        int z, y, x;
        Node(int z, int y, int x) {
            this.z = z; this.y = y; this.x = x;
        }
    }

    static int bfs(Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.z][start.y][start.x] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (map[cur.z][cur.y][cur.x] == 'E') {
                return visited[cur.z][cur.y][cur.x];
            }

            for (int d = 0; d < 6; d++) {
                int nz = cur.z + dz[d];
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if (nz >= 0 && nz < L && ny >= 0 && ny < R && nx >= 0 && nx < C &&
                        map[nz][ny][nx] != '#' && visited[nz][ny][nx] == -1) {
                    visited[nz][ny][nx] = visited[cur.z][cur.y][cur.x] + 1;
                    queue.offer(new Node(nz, ny, nx));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            visited = new int[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    map[i][j] = line.toCharArray();
                    Arrays.fill(visited[i][j], -1);
                }
                br.readLine(); // 빈 줄 처리
            }

            Node start = null;
            for (int z = 0; z < L; z++) {
                for (int y = 0; y < R; y++) {
                    for (int x = 0; x < C; x++) {
                        if (map[z][y][x] == 'S') {
                            start = new Node(z, y, x);
                        }
                    }
                }
            }

            int result = bfs(start);
            if (result == -1) sb.append("Trapped!\n");
            else sb.append("Escaped in ").append(result).append(" minute(s).\n");
        }

        System.out.print(sb);
    }
}
