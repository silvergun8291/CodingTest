import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;   // 세로 크기
    static int C;   // 가로 크기
    int [][] hall;  // 공연장

    static boolean check(int count, int waitNum) {
        return count == waitNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 공연장의 크기를 입력 받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());    // 가로 크기
        R = Integer.parseInt(st.nextToken());    // 세로 크기
        int count = 0;                           // 입장 관객수를 카운트 할 변수
        int targetX;                             // 배정될 좌석의 X 좌표
        int targetY;                             // 배정될 좌석의 Y 좌표

        // 관객의 대기번호를 입력받음
        int waitNum = Integer.parseInt(br.readLine());

        if (C * R < waitNum) {
            System.out.println(0);
            return;
        }

        int left = 0;       // 왼쪽 끝 변수
        int right = C-1;    // 오른쪽 끝 변수
        int up = 0;         // 위쪽 끝 변수
        int down = R-1;     // 아래쪽 끝 변수
        int x = 0;              // 현재 x 좌표
        int y = 0;              // 현재 y 좌표

        // 관객 번호 수 만큼 입장을 시키기 위해 반복문을 돌림
        while (true) {
            // 위로 이동
            for (int i = down; i >= up; i--) {
                if (check(count, waitNum)) {
                    targetX = x;
                    targetY = R - y - 1;
                    break;
                } else {
                    x = left;
                    y = i;
                    count++;
                }
            }

            // 왼쪽 차원 축소
            left++;

            // 오른쪽으로 이동
            for (int i = left; i <= right; i++) {
                if (check(count, waitNum)) {
                    targetX = x;
                    targetY = R - y - 1;
                    break;
                } else {
                    x = i;
                    y = up;
                    count++;
                }
            }

            // 위쪽 차원 축소
            up++;

            // 아래쪽으로 이동
            for (int i = up; i <= down; i++) {
                if (check(count, waitNum)) {
                    targetX = x;
                    targetY = R - y - 1;
                    break;
                } else {
                    x = right;
                    y = i;
                    count++;
                }
            }

            // 오른쪽 차원 축소
            right--;

            // 왼쪽으로 이동
            for (int i = right; i >= left; i--) {
                if (check(count, waitNum)) {
                    targetX = x;
                    targetY = R - y - 1;
                    break;
                } else {
                    x = i;
                    y = down;
                    count++;
                }
            }

            // 아래쪽 차원 축소
            down--;

            if (check(count, waitNum)) {
                targetX = x;
                targetY = R - y - 1;
                break;
            }
        }

        System.out.println((targetX+1) + " " + (targetY+1));
    }
}
