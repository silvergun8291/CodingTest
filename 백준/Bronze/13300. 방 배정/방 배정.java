import java.io.*;
import java.util.*;

public class Main {
    static int [][] students = new int [6][2];  // 학생들을 저장할 배열
    static int N;   // 전체 학생 수
    static int k;   // 최대 인원 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 전체 학생 수를 입력 받음
        k = Integer.parseInt(st.nextToken());   // 최대 인원 수를 입력 받음
        int room = 0;   // 방수

        // 반복문을 돌며 학생 정보를 입력받아 배열에 기록
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());   // 성별 (0-여, 1-남)
            int y = Integer.parseInt(st.nextToken());   // 학년 (1~6)

            students[y-1][s] += 1;  // 각 학년 별 성별 별 학생 수를 학생 배열에 기록
        }

        // 반목문을 돌며 학생 정보를 바탕으로 방 배정
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                // 최대 인원수로 학생 수를 나눈 값을 올림하여 방 개수를 구함
                room += (int) Math.ceil((float) students[i][j] / k);
            }
        }

        System.out.println(room);   // 방 개수 출력
    }
}