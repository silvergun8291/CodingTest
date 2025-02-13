import java.util.*;
import java.io.*;

public class Main { 
    static int N;
    static int L;
    static int R;
    static int [][] map;
    static int [][] visited;
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};

    // 인구 이동이 불가능한지 확인하는 함수
    static boolean isNotMoveable(List<List<int[]>> alliances) {
        return alliances.size() == N * N;
    }

    // 새로운 좌표가 탐색 범위 안에 있는지 확인하기 위한 함수
    static boolean boundCheck(int y, int x) {
        return y >= 0 && y < 2 * N - 1 && x >= 0 && x < 2 * N - 1;
    }

    // 연합을 만들기 위한 BFS (국경(–2)이 열렸을 때만 이동)
    static List<int[]> bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {y, x});
        visited[y][x] = 1;
        List<int[]> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            // 실제 국가(짝수, 짝수 위치)만 결과에 추가
            if (map[curr[0]][curr[1]] != -2)
                result.add(curr);

            for (int i = 0; i < 4; i++) {
                int newY = curr[0] + dy[i];
                int newX = curr[1] + dx[i];

                if (boundCheck(newY, newX) && map[newY][newX] != -1 && visited[newY][newX] == 0) {
                    queue.offer(new int[] {newY, newX});
                    visited[newY][newX] = 1;
                }
            }
        }

        return result;
    }

    static void determineBound() {
        // 가로 경계 세팅 (국가와 국가 사이)
        for (int i = 0; i < 2 * N - 1; i += 2) {
            for (int j = 0; j < 2 * N - 2; j += 2) {
                int diff = Math.abs(map[i][j] - map[i][j+2]);
                if (L <= diff && diff <= R) {
                    map[i][j+1] = -2;  // 국경선 열기
                    visited[i][j+1] = 0;
                } else {
                    map[i][j+1] = -1;  // 국경선 닫기
                    visited[i][j+1] = -1;
                }
            }
        }
        // 세로 경계 세팅 (국가와 국가 사이)
        for (int i = 0; i < 2 * N - 1; i += 2) {
            for (int j = 0; j < 2 * N - 2; j += 2) {
                int diff = Math.abs(map[j][i] - map[j+2][i]);
                if (L <= diff && diff <= R) {
                    map[j+1][i] = -2;  // 국경선 열기
                    visited[j+1][i] = 0;
                } else {
                    map[j+1][i] = -1;  // 국경선 닫기
                    visited[j+1][i] = -1;
                }
            }
        }
        // ★ 교차점(행, 열이 홀수인 위치)는 항상 국경 닫힘 처리
        for (int i = 1; i < 2 * N - 1; i += 2) {
            for (int j = 1; j < 2 * N - 1; j += 2) {
                map[i][j] = -1;
                visited[i][j] = -1;
            }
        }
    }

    static void updatePopulation(List<List<int[]>> alliances) {
        List<Integer> avg = new ArrayList<>();

        for (List<int[]> alliance : alliances) {
            int sum = 0;
            for (int[] row : alliance) {
                sum += map[row[0]][row[1]];
            }
            avg.add(sum / alliance.size());
        }

        for (int i = 0; i < alliances.size(); i++) {
            List<int[]> alliance = alliances.get(i);
            for (int j = 0; j < alliance.size(); j++) {
                int[] row = alliance.get(j);
                map[row[0]][row[1]] = avg.get(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 땅의 크기
        L = Integer.parseInt(st.nextToken());   // 인구 차이 최소
        R = Integer.parseInt(st.nextToken());   // 인구 차이 최대

        map = new int[2 * N - 1][2 * N - 1]; // 국가 및 경계(국경, 교차점) 저장 배열

        // 초기화: 모든 칸을 기본값 -2 (국경 열림)으로 설정
        for (int i = 0; i < 2 * N - 1; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                map[i][j] = -2;
            }
        }

        // 실제 국가 값 입력 (짝수 행, 짝수 열)
        for (int i = 0; i < 2 * N - 1; i += 2) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2 * N - 1; j += 2) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) {
            visited = new int[2 * N - 1][2 * N - 1]; // 방문 여부 배열 초기화

            determineBound();

            List<List<int[]>> alliances = new ArrayList<>();

            for (int i = 0; i < 2 * N - 1; i++) {
                for (int j = 0; j < 2 * N - 1; j++) {
                    List<int[]> alliance = new ArrayList<>();
                    if (visited[i][j] == 0)
                        alliance = bfs(i, j);
                    if (!alliance.isEmpty())
                        alliances.add(alliance);
                }
            }

            if (isNotMoveable(alliances))
                break;

            day++;
            updatePopulation(alliances);
        }

        System.out.println(day);
    }
}
