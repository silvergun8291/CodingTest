import java.io.*;
import java.util.*;

public class Main {
    static int N, M;            // N과 M
    static int[] numbers;       // 입력받은 숫자들을 저장할 배열
    static boolean[] visited;   // 방문 여부를 나타낼 배열
    static StringBuilder result = new StringBuilder();  // 결과를 저정할 변수

    // DFS 탐색을 하며 수열을 찾는 함수
    public static void dfs(int depth, int[] current) {
        // 주어진 길이의 수열을 만들었으면
        if (depth == M) {
            // result에 수열을 추가하고
            for (int i = 0; i < M; i++) {
                result.append(current[i]).append(" ");
            }
            result.append("\n");
            return; // 함수 종료
        }

        // 아니면
        for (int i = 0; i < N; i++) {
            // 방문 여부를 체크하여 동일한 숫자가 두번 들어가는 것을 방지
            if (!visited[i]) {
                visited[i] = true;              // 방문 여부를 true로 세팅
                current[depth] = numbers[i];    // 현재 방문 숫자 current 배열에 추가
                dfs(depth + 1, current);        // dfs로 추가 탐색
                visited[i] = false;             // 방문 여부를 false로 세팅
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // N을 입력받음
        M = Integer.parseInt(st.nextToken());   // M을 입력받음
        numbers = new int[N];

        // 반복문을 돌며 숫자들을 입력받음
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 사전순으로 증가하는 순서로 출력하기 위해 입력받은 숫자들을 정렬
        Arrays.sort(numbers);

        visited = new boolean[N + 1];   // 방문 여부를 체크할 배열
        dfs(0, new int[M]);             // dfs 함수를 호출하여 수열을 구함

        // 결과에서 중복 제거
        String[] lines = result.toString().split("\n");
        LinkedHashSet<String> unique = new LinkedHashSet<>();
        Collections.addAll(unique, lines);

        for (String line: unique)
            System.out.println(line);
    }
}