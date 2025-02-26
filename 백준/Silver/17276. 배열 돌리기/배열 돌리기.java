import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int [][] board;
    static int [][] result;

    // 가운데 열을 추출하는 함수 |
    static int [] getMiddleCol() {
        int [] result = new int[N];

        for (int i = 0; i < N; i++) {
            result[i] = board[i][N/2];
        }

        return result;
    }

    // 가운데 행을 추출하는 함수 -
    static int [] getMiddleRow() {
        int [] result = new int[N];

        for (int i = 0; i < N; i++) {
            result[i] = board[N/2][i];
        }

        return result;
    }

    // 주 대각선을 추출하는 함수 \
    static int [] getPrimaryCross() {
        int [] result = new int[N];

        for (int i = 0; i < N; i++) {
            result[i] = board[i][i];
        }

        return result;
    }

    // 부 대각선을 추출하는 함수 /
    static int [] getSecondaryCross() {
        int [] result = new int[N];

        for (int i = 0; i < N; i++) {
            result[i] = board[N-1-i][i];
        }

        return result;
    }

    // 배열을 회전시키는 함수
    static void rotate() {
        int [] middleRow = getMiddleRow();              // -
        int [] middleCol = getMiddleCol();              // |
        int [] primaryCross = getPrimaryCross();        // \
        int [] secondaryCross = getSecondaryCross();    // /

        for (int i = 0; i < N; i++) {
            // 주 대각선을 가운데 열로 옮김 (\ -> |)
            result[i][N/2] = primaryCross[i];

            // 가운데 열을 부 대각선으로 옮김 (| -> /)
            result[i][N-1-i] = middleCol[i];

            // 부 대각선을 가운데 행으로 옮김 (/ -> -)
            result[N/2][i] = secondaryCross[i];

            // 가운데 행을 주 대각선으로 옮김 (- -> \)
            result[i][i] = middleRow[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (result[i][j] == 0)
                    result[i][j] = board[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());           // 배열의 가로 세로 길이를 입력받음
            int degree = Integer.parseInt(st.nextToken());  // 회전시킬 각도를 입력받음
            board = new int[N][N];
            result = new int[N][N];

            // 배열을 입력받음
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int rotateCount = 0;

            if (degree > 0)
                rotateCount = degree / 45;
            else if (degree < 0)
                rotateCount = (360 + degree) / 45;

            if (rotateCount > 0) {
                for (int i = 0; i < rotateCount; i++) {
                    rotate();
                    board = result;
                }
            }
            else  {
                result = board;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(result[i][j]).append(" ");
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
