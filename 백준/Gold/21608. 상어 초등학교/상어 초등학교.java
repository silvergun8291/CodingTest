
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Map<Integer, int[]> prefMap = new HashMap<>();

    static boolean boundCheck(int y, int x) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static boolean isIn(int val, int [] array) {
        for (int j : array) {
            if (val == j) return true;
        }
        return false;
    }

    static int countLikes(int y, int x, int [] likes) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (boundCheck(newY, newX) && isIn(board[newY][newX], likes)) {
                count++;
            }
        }

        return count;
    }

    static int countEmpty(int y, int x) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (boundCheck(newY, newX) && board[newY][newX] == 0) {
                count++;
            }
        }

        return count;
    }

    static int satisfactionScore(int y, int x, int[] likes) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (boundCheck(ny, nx) && isIn(board[ny][nx], likes)) {
                cnt++;
            }
        }

        switch (cnt) {
            case 0: return 0;
            case 1: return 1;
            case 2: return 10;
            case 3: return 100;
            case 4: return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int [] likes = new int[4];

            for (int j = 0; j < 4; j++) {
                likes[j] = Integer.parseInt(st.nextToken());
            }

            prefMap.put(number, likes);

            // 초기값 설정
            int maxLikeCount = -1; 
            int maxEmptyCount = -1; 
            int x = -1; 
            int y = -1;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (board[j][k] != 0)
                        continue;

                    int likeCount = countLikes(j, k, likes);
                    int emptyCount = countEmpty(j, k);

                    if (likeCount > maxLikeCount || 
                       (likeCount == maxLikeCount && emptyCount > maxEmptyCount) || 
                       (likeCount == maxLikeCount && emptyCount == maxEmptyCount && (j < y || (j == y && k < x)))) {

                        maxLikeCount = likeCount;
                        maxEmptyCount = emptyCount;

                        y = j;
                        x = k;
                    }
                }
            }

            board[y][x] = number;
        }

        // 만족도 계산
        int totalLikes = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                totalLikes += satisfactionScore(i, j, prefMap.get(board[i][j]));
            }
        }

        System.out.println(totalLikes);
    }
}
