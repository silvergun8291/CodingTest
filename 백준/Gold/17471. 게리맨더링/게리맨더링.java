/**
 * 아이디어 : 조합을 통해 지역구 분할하기 -> 연결되어 있는지 확인하기 -> 인구 차이 계산 및 최소값 갱신
 * 시간 : 120 ms
 * 메모리 : 15120 kb
 * 난이도 : 상 (구현은 금방했는데, 시간 초과가 계속 터져서 최적화 하기가 힘듣었습니다.)
 */

import java.io.*;
import java.util.*;

public class Main {
    static int N;                   // 구역 개수
    static List<Integer>[] graph;
    static int [] population;
    static int[] selectArea;
    static int[] unselectArea;
    static int minDiff;

    static int bfs(int start, int size, int[] other) {
        int count = 1;
        int sum = 0;
        boolean[] visited = new boolean[N+1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sum += population[current];

            for (Integer n: graph[current]) {
                if (visited[n]) continue;

                boolean found = false;
                for (int o: other) {
                    if (o == n) {
                        found = true;
                        break;
                    }
                }

                if (found) continue;

                queue.add(n);
                visited[n] = true;
                count++;
            }
        }

        if (count == size)
            return sum;
        else
            return -1;
    }

    static void dfs(int cnt, int R, int start) {
        // 기저 조건
        if (cnt == R) {
            // 구역 나누기
            unselectArea = new int[N - R];
            boolean[] isSelected = new boolean[N + 1];

            for (int i = 0; i < R; i++) {
                isSelected[selectArea[i]] = true;
            }

            int idx = 0;
            for (int i = 1; i <= N; i++) {
                if (!isSelected[i]) {
                    unselectArea[idx++] = i;
                }
            }

            // 연결 확인하기
            int sum1 = bfs(selectArea[0], R, unselectArea);

            if (sum1 == -1) return;

            int sum2 = bfs(unselectArea[0], N - R, selectArea);

            // 두 선거구 모두 연결되어 있으면
            if (sum2 != -1) {
                // 차이 최소값 업데이트
                int diff = Math.abs(sum1 - sum2);
                minDiff = Math.min(diff, minDiff);
            }

            return; // 종료
        }

        for (int i = start; i <= N; i++) {
            selectArea[cnt] = i;
            dfs(cnt + 1, R, i + 1);
        }
    }

    static void simulate() {
        for (int r = 1; r <= N / 2; r++) {
            selectArea = new int[r];
            dfs(0, r, 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    // 구역의 개수를 입력받음
        graph = new List[N + 1];
        population = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 구역별 인구수를 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        // 지역별 연결 관계를 입력받음
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            // 연결된 구역 개수
            int k = Integer.parseInt(st.nextToken());

            // 그래프에 구역 연결하기
            for (int j = 1; j <= k; j++) {
                int a = Integer.parseInt(st.nextToken());
                graph[i].add(a);
                graph[a].add(i);
            }
        }

        minDiff = Integer.MAX_VALUE;

        // 게리멘더링 시뮬레이션
        simulate();

        if (minDiff == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minDiff);
    }
}