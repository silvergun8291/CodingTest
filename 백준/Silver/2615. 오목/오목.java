import java.io.*;
import java.util.*;

public class Main {
    static int N = 19;
    static int[][] board = new int[N][N];
    static int winX, winY; // 승리 시 출력할 좌표 (0-indexed): winX는 열, winY는 행

    // 보드판의 경계 검사
    static boolean boundCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    // 주어진 좌표 (x, y)에서 4가지 방향에 대해 정확히 5개의 연속된 돌이 있는지 확인하고,
    // 승리 조건(6목이 아님)을 만족하면 승리 돌의 번호를 반환하고, 그 때의 승리 좌표를 전역 변수에 저장한다.
    static int gameCheck(int x, int y) {
        int current = board[y][x];
        if(current == 0) return 0;
        int M = 5;
        boolean check;

        // 가로 체크 (오른쪽 방향: dx=1, dy=0)
        check = true;
        for (int i = 0; i < M; i++) {
            if (!boundCheck(x + i, y) || board[y][x + i] != current) {
                check = false;
                break;
            }
        }
        if (check) {
            // 6목 여부 확인: 왼쪽과 오른쪽에 추가 돌이 있는지 검사
            if ((boundCheck(x - 1, y) && board[y][x - 1] == current) ||
                (boundCheck(x + M, y) && board[y][x + M] == current)) {
                check = false;
            }
        }
        if (check) {
            winX = x;    // 가로인 경우 가장 왼쪽 돌은 (x, y)
            winY = y;
            return current;
        }

        // 세로 체크 (아래 방향: dx=0, dy=1)
        check = true;
        for (int i = 0; i < M; i++) {
            if (!boundCheck(x, y + i) || board[y + i][x] != current) {
                check = false;
                break;
            }
        }
        if (check) {
            if ((boundCheck(x, y - 1) && board[y - 1][x] == current) ||
                (boundCheck(x, y + M) && board[y + M][x] == current)) {
                check = false;
            }
        }
        if (check) {
            winX = x;
            winY = y; // 세로인 경우 가장 위의 돌이 (x, y)
            return current;
        }

        // 왼쪽 대각선 체크 (dx = -1, dy = 1)
        check = true;
        for (int i = 0; i < M; i++) {
            if (!boundCheck(x - i, y + i) || board[y + i][x - i] != current) {
                check = false;
                break;
            }
        }
        if (check) {
            if ((boundCheck(x + 1, y - 1) && board[y - 1][x + 1] == current) ||
                (boundCheck(x - M, y + M) && board[y + M][x - M] == current)) {
                check = false;
            }
        }
        if (check) {
            // 왼쪽 대각선의 경우, 5개 돌 중 가장 왼쪽에 해당하는 좌표는 (x - 4, y + 4)
            winX = x - 4;
            winY = y + 4;
            return current;
        }

        // 오른쪽 대각선 체크 (dx = 1, dy = 1)
        check = true;
        for (int i = 0; i < M; i++) {
            if (!boundCheck(x + i, y + i) || board[y + i][x + i] != current) {
                check = false;
                break;
            }
        }
        if (check) {
            if ((boundCheck(x - 1, y - 1) && board[y - 1][x - 1] == current) ||
                (boundCheck(x + M, y + M) && board[y + M][x + M] == current)) {
                check = false;
            }
        }
        if (check) {
            winX = x;
            winY = y; // 오른쪽 대각선의 경우, 가장 왼쪽(혹은 위쪽) 돌은 (x, y)
            return current;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 보드 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        // 왼쪽 위부터 오른쪽 아래까지 순서대로 검사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) { // 빈 칸은 skip
                    result = gameCheck(j, i);
                    if (result != 0) {
                        System.out.println(result);
                        // 문제에서는 행, 열을 1-indexed로 출력
                        System.out.println((winY + 1) + " " + (winX + 1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
