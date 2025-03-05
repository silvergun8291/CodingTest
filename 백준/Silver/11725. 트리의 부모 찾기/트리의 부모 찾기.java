import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 인접 리스트 생성 (인덱스 0은 사용하지 않음)
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 간선 정보 저장
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        boolean[] visited = new boolean[N + 1];
        int[] parent = new int[N + 1];

        // BFS를 위한 큐
        Queue<Integer> queue = new ArrayDeque<>();

        // 루트 (1) 초기 설정
        visited[1] = true;
        queue.offer(1);

        // BFS 진행
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : tree.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = current;
                    queue.offer(next);
                }
            }
        }

        // 결과 출력 (노드 2부터 N까지의 부모 노드)
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }
}