import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int SIZE = 5;    // 빙고판 가로 세로 길이
    static int[][] board = new int[SIZE][SIZE];     // 빙고 보드판
    static int[] call = new int[SIZE * SIZE];      // 사회자 부르는 숫자

    // 사회자가 숫자를 부르면 해당 숫자를 0으로 변환
    static void checkNumber(int value) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (value == board[i][j]) {
                    board[i][j] = 0;
                }
            }
        }
    }

    // 가로 빙고의 개수를 구하는 함수
    static int checkHorizontal() {
        int bingo = 0;  // 빙고의 개수를 카운트 할 변수

        for (int i = 0; i < SIZE; i++) {
            int check = 0;  // 빙고판의 숫자가 사회자가 부른 숫자인지 체크할 변수
            for (int j = 0; j < SIZE; j++) {
                // 세로로 한 칸씩 이동하면서 사회자가 해당 숫자를 불렀는지 확인
                if (board[i][j] == 0) {
                    // 불렀으면 check 값을 1 증가
                    check++;
                }
            }

            // 만약 가로 칸 5개 모두 사회자가 불렀다면
            if (check == 5) {
                // 빙고의 개수 증가
                bingo++;
            }
        }

        return bingo;   // 빙고의 개수 반환
    }

    // 세로 빙고의 개수를 구하는 함수
    static int checkVertical() {
        int bingo = 0;  // 빙고의 개수를 카운트 할 변수

        for (int i = 0; i < SIZE; i++) {
            int check = 0;  // 빙고판의 숫자가 사회자가 부른 숫자인지 체크할 변수
            for (int j = 0; j < SIZE; j++) {
                // 세로로 한 칸씩 이동하면서 사회자가 해당 숫자를 불렀는지 확인
                if (board[j][i] == 0) {
                    // 불렀으면 check 값을 1 증가
                    check++;
                }
            }

            // 만약 세로 칸 5개 모두 사회자가 불렀다면
            if (check == 5) {
                // 빙고의 개수 증가
                bingo++;
            }
        }

        return bingo;   // 빙고의 개수 반환
    }

    static int checkDiagonal() {
        int bingo = 0;

        // \ 대각선 빙고 체크
        if ((board[0][0] == 0) && (board[1][1] == 0) && (board[2][2] == 0)
                && (board[3][3] == 0) && (board[4][4] == 0)) {
            bingo++;
        }

        // / 대각선 빙고 체크
        if ((board[0][4] == 0) && (board[1][3] == 0) && (board[2][2] == 0)
                && (board[3][1] == 0) && (board[4][0] == 0)) {
            bingo++;
        }

        return bingo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bingo = 0;  // 빙고 개수를 저장할 변수

        // 빙고 보드판을 입력받음
        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 사회자가 부르는 숫자들을 입력받음
        int index = 0;
        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                call[index++] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;  // 사회자가 번호를 몇번 불렀는지 카운트 할 변수
        for (int i = 0; i < SIZE * SIZE; i++) {
            count++;    // 사회자가 부른 번호수를 1증가 시킴

            // 사회자가 부른 번호를 보드판에서 찾아 0으로 바꿈
            checkNumber(call[i]);

            // 가로, 세로, 대각선 빙고의 개수를 체크
            int bingoH = checkHorizontal();
            int bingoV = checkVertical();
            int bingoD = checkDiagonal();

            // 빙고의 총 개수를 구함
            bingo = bingoH + bingoV + bingoD;

            // 빙고의 총 개수가 3개 이상이면 반복문 종료
            if (bingo >= 3) {
                break;
            }
        }

        // 3빙고 까지 걸린 턴수를 출력
        System.out.println(count);
    }
}
