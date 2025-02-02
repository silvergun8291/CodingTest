import java.io.*;
import java.util.*;

public class Main {
    static int [][] dice;

    // 주사위 반대편 인덱스를 반환하는 함수
    static int getOppositeFace(int idx) {
        if (idx == 0)
            return 5;
        else if (idx == 1)
            return 3;
        else if (idx == 2)
            return 4;
        else if (idx == 3)
            return 1;
        else if (idx == 4)
            return 2;
        else
            return 0;
    }

    // 주사위 옆면에서 최대 값을 찾아서 반환하는 함수
    static int getMaxSide(int index, int top, int bottom) {
        int maxSide = 0;

        for (int i = 0; i < 6; i++) {
            // 윗면과 아래면이 아닌 면중 최대 값을 찾음
            if (dice[index][i] != top && dice[index][i] != bottom)
                maxSide = Math.max(maxSide, dice[index][i]);
        }

        return maxSide;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 주사위 개수
        dice = new int[N][6];   // 주사위 면의 값을 저장할 배열
        int maxSum = 0; // 주사위 옆면의 합의 최대값

        // 반복문을 돌며 주사위 면의 값을 입력받음
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < 6; i++) {
            int sum = 0;    // 주사위 옆면의 합
            int top = dice[0][i];   // 주사위 윗면
            int bottom = dice[0][getOppositeFace(i)];   // 주사위 아래면
            sum += getMaxSide(0, top, bottom);   // 첫번째 주사위의 최대 옆면의 값을 더함

            // 두번째 주사위 부터 최대 옆면의 값을 더함
            for (int j = 1; j < N; j++) {
                for (int k = 0; k < 6; k++) {
                    if (dice[j][k] == top) {    // 이전 주사위 위면을 찾아서
                        bottom = top;   // 이번 주사위 아래면을 세팅하고
                        top = dice[j][getOppositeFace(k)];  // 위면도 세팅

                        sum += getMaxSide(j, top, bottom);  // 옆면 중 최대 값을 찾아 주사위 옆면의 합에 더함
                        break;
                    }
                }
            }

            // 주사위를 쌓는 모든 경우의 수를 계산해서 최대 옆면의 합을 구함
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum); // 결과 출력
    }
}