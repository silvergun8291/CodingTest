import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 아이디어 : 시간 제한이 1초 이기 때문에, 색종이가 붙은 구역을 check 표시하고 check 표시 개수를 세는 방식을 사용
 * 시간 :
 * 메모리 :
 * 난이도 : 하 (시간 복잡도가 널널하고 구현 아이디어가 금방 떠올라서 쉽게 해결할 수 있었습니다.)
 */

public class Main {
    static int N;   // 색종이 개수
    static int colorSize = 10;  // 색종이의 크기
    static int whiteSize = 100; // 도화지 사이즈
    static int [][] board = new int[whiteSize][whiteSize];  // 도화지

    // x, y 좌표가 주어지면 해당 좌표에 색종이를 붙일 함수
    static void mark(int x, int y) {
        // board 배열에서 해당 영역에 모두 true 값을 대입
        for (int i = y; i < y + colorSize; i++) {
            for (int j = x; j < x + colorSize; j++) {
                board[i][j] = 1;
            }
        }
    }

    static int countMark() {
        int count = 0;

        for (int i = 0; i < whiteSize; i++) {
            for (int j = 0; j < whiteSize; j++) {
                if (board[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 색종이의 개수를 입력받음
        N = Integer.parseInt(br.readLine());
        int area = 0;

        // 색종이의 좌표를 입력받아 도화지를 채움
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());   // 색종이 x 좌표
            int y = Integer.parseInt(st.nextToken());   // 색종이 y 좌표

            mark(x, y); // 도화지에 색종이 영역을 채움
        }

        area = countMark(); // 도화지에 색종이 영역을 카운트
        System.out.println(area);   // 색종이 영역의 넓이를 출력
    }
}
