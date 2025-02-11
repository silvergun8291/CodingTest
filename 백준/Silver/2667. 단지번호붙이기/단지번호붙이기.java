import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int [][] graph;
    static boolean [][] visited;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, 1, 0, -1};
    static List<Integer> result;
    static int size;

    static boolean boundCheck(int y, int x) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static void DFS(int currentY, int currentX) {
        size++;
        visited[currentY][currentX] = true;

        for (int i = 0; i < 4; i++) {
            int newX = currentX + dx[i];
            int newY = currentY + dy[i];

            if (boundCheck(newY, newX) && graph[newY][newX] == 1 && !visited[newY][newX]) {
                DFS(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 지도의 크기를 입력받음
        graph = new int[N][N];

        // 지도를 입력받음
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                graph[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        visited =new boolean[N][N];        // visited 배열을 초기화
        result = new ArrayList<>();      // result 변수를 초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    size = 0;
                    DFS(i, j);
                    result.add(size);
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}