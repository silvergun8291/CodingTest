import java.io.*;
import java.util.*;

public class Main {
    static int N, M;    // N과 M
    static StringBuilder result = new StringBuilder();  // 결과를 저정할 변수

    // DFS 탐색을 하며 수열을 찾는 함수
    public static void dfs(int depth, int[] current) {
        // 주어진 길이의 수열을 만들었으면
        if (depth == M) {
            boolean asc = true; // 오름차순 여부를 체크할 변수
            int prev = 0;       // 오름차순 체크를 위해 이전 값을 저장할 변수

            // 이전값과 현재값을 비교하여 오름차순 여부를 판단
            for (int i = 0; i < M; i++) {
                if (prev > current[i]) {
                    asc = false;
                    break;
                }

                prev = current[i];
            }

            if (asc) {
                // result에 수열을 추가하고
                for (int i = 0; i < M; i++) {
                    result.append(current[i]).append(" ");
                }
                result.append("\n");
            }

            return; // 함수 종료
        }

        // 아니면
        for (int i = 1; i <= N; i++) {
            current[depth] = i;         // 현재 방문 숫자 current 배열에 추가
            dfs(depth + 1, current);    // dfs로 추가 탐색
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // N을 입력받음
        M = Integer.parseInt(st.nextToken());   // M을 입력받음

        dfs(0, new int[M]);             // dfs 함수를 호출하여 수열을 구함
        System.out.println(result);     // 결과를 출력
    }
}