import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] maze;
    static int[][] fireTime;   // 각 칸에 불이 도착하는 최소 시간 (도달할 수 없으면 INF)
    static int[][] jihoonTime; // 지훈이가 도착하는 최소 시간 (미방문은 -1)
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        maze = new char[R][C];
        fireTime = new int[R][C];
        jihoonTime = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            maze[i] = br.readLine().toCharArray();
            Arrays.fill(fireTime[i], INF);
            Arrays.fill(jihoonTime[i], -1);
        }
        
        // 다중 시작점 BFS를 위한 큐
        Queue<int[]> fireQ = new ArrayDeque<>();
        Queue<int[]> jQ = new ArrayDeque<>();
        
        // 초기 불의 위치와 지훈이의 위치 큐에 저장
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (maze[i][j] == 'F') {
                    fireTime[i][j] = 0;
                    fireQ.offer(new int[] {i, j});
                }
                if (maze[i][j] == 'J') {
                    jihoonTime[i][j] = 0;
                    jQ.offer(new int[] {i, j});
                }
            }
        }
        
        // 1. 불의 도달 시간 계산 (다중 시작점 BFS)
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int y = cur[0], x = cur[1];
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d], nx = x + dx[d];
                if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                if (maze[ny][nx] == '#') continue;
                if (fireTime[ny][nx] <= fireTime[y][x] + 1) continue; // 이미 더 빠른 시간에 도착한 경우
                fireTime[ny][nx] = fireTime[y][x] + 1;
                fireQ.offer(new int[] {ny, nx});
            }
        }
        
        // 2. 지훈이의 이동 BFS
        while (!jQ.isEmpty()) {
            int[] cur = jQ.poll();
            int y = cur[0], x = cur[1];
            
            // 현재 위치가 경계면이면 탈출 가능 (문제에서 탈출은 1분 후 이루어짐)
            if (y == 0 || y == R - 1 || x == 0 || x == C - 1) {
                System.out.println(jihoonTime[y][x] + 1);
                return;
            }
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d], nx = x + dx[d];
                if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                if (maze[ny][nx] == '#' || jihoonTime[ny][nx] != -1) continue;
                
                int nextTime = jihoonTime[y][x] + 1;
                // 불이 해당 칸에 도착하기 전에 도착해야 이동 가능
                if (nextTime >= fireTime[ny][nx]) continue;
                
                jihoonTime[ny][nx] = nextTime;
                jQ.offer(new int[] {ny, nx});
            }
        }
        
        // 탈출 불가능한 경우
        System.out.println("IMPOSSIBLE");
    }
}