import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] cards = new int[N][M];

        // 박스별 카드 정보를 입력 받음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;    // 카드 정리 수
        int [] types = new int[M];  // 한 종류의 카드로 이루어진 박스의 유형별 개수

        for (int i = 0; i < N; i++) {
            int count = 0;
            int type = -1;

            // 해당 박스의 카드 종류 개수를 카운트
            for (int j = 0; j < M; j++) {
                if (cards[i][j] > 0) {
                    count++;
                    type = j;   // 한 종류의 카드로 이루어진 박스의 경우 카드 종류를 기록하기 위한 변수
                }
            }

            // 한 종류의 카드로 이루어진 박스의 경우
            if (count == 1)
                types[type]++;  // 해당 카드 종류 박스 카운트 1 증가

            // 여러 종류의 카드로 이루어진 박스는 그냥 조커 박스에 넣어버림
            if (count > 1)
                result++;
        }

        // 한 종류의 카드로 이루어진 박스에서 카드 유형이 동일한 박스가 여러개면
        for (int type: types) {
            // 합친다
            if (type > 0)
                result += type - 1;
        }

        // 조커 박스의 개수를 빼줌
        if (result > 0)
            result -= 1;

        System.out.println(result); // 결과 출력
    }
}
