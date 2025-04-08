import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int blankCount;

    // 방향 벡터: 북(0), 동(1), 남(2), 서(3)
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    // 경계 확인 함수
    static boolean boundCheck(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    // 청소 함수
    static void clean(int y, int x, int direction) {
        while (true) {
            // 1. 현재 위치 청소
            if (map[y][x] == 0 && !visited[y][x]) {
                visited[y][x] = true;
                blankCount++;
            }

            boolean movedForward = false; // 앞으로 이동했는지 여부

            // 2. 왼쪽 방향부터 탐색 (네 방향 확인)
            for (int i = 0; i < 4; i++) {
                direction = (direction + 3) % 4; // 왼쪽으로 회전
                int nextY = y + dy[direction]; // 다음 행 좌표
                int nextX = x + dx[direction]; // 다음 열 좌표

                // 왼쪽 방향에 청소하지 않은 공간 존재 시
                if (boundCheck(nextY, nextX) && map[nextY][nextX] == 0 && !visited[nextY][nextX]) {
                    y = nextY; // 전진
                    x = nextX;
                    movedForward = true; // 이동 성공 플래그 설정
                    break; // 탐색 중단하고 다시 1번부터 시작
                }
            }

            // 3. 네 방향 모두 청소되었거나 벽인 경우
            if (!movedForward) {
                int backDirection = (direction + 2) % 4; // 현재 방향 기준 후진 방향
                int backY = y + dy[backDirection]; // 후진할 행 좌표
                int backX = x + dx[backDirection]; // 후진할 열 좌표

                // 뒤쪽이 벽이라 후진할 수 없는 경우
                if (!boundCheck(backY, backX) || map[backY][backX] == 1) {
                    break; // 작동 중지
                } else {
                    // 후진 가능하면 후진
                    y = backY;
                    x = backX;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 크기를 입력받음
        M = Integer.parseInt(st.nextToken()); // 가로 크기를 입력받음

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken()); // 시작 행 좌표를 입력받음
        int startX = Integer.parseInt(st.nextToken()); // 시작 열 좌표를 입력받음
        int startD = Integer.parseInt(st.nextToken()); // 시작 방향을 입력받음

        // 초기화
        map = new int[N][M];
        visited = new boolean[N][M];
        blankCount = 0;

        // 지도 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 청소 시작
        clean(startY, startX, startD);

        System.out.println(blankCount); // 결과 출력
    }
}
