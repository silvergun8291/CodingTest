import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 학생 번호 전체를 왼쪽으로 밀기 위한 함수
    static void pushLeft(int [] arr, int index) {
        // 밀어야 할 값의 시작 지점
        int start = 0;

        // 밀어야 할 값의 시작 지점을 찾음
        for (int i = 0; i <= index; i++) {
            if (arr[i] != 0) {
                start = i;
                break;
            }
        }

        // 여러개의 값을 차례대로 왼쪽으로 밀어버림
        for (int i = start; i <= index; i++) {
            arr[i-1] = arr[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    // 전체 학생 수 입력받기
        int [] number = new int[N];     // 학생들이 뽑은 숫자를 저장할 배열 만들기

        // 학생들이 뽑은 숫자를 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());


        // 학생들이 뽑은 숫자를 number 배열에 대입
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        // 학생이 한명이면 1을 출력하고 종료
        if (N == 1) {
            System.out.println(1);
            return;
        }

        // 학생 수의 * 2 - 1 크기의 배열을 만들고 가운데를 중심으로 확장하는 방식으로 문제해결
        int size = (N * 2) - 1;
        int last = size / 2;    // 마지막 학생이 존재하는 인덱스
        int count = 1;          // 학생 번호
        int [] students = new int[size];    // 학생 순서를 저장할 배열
        students[last] = count;     // 첫 번째 학생 배열에 저장
        for (int i = 1; i < N; i++) {
            count++;    // 학생 번호 증가

            // 학생이 0번을 뽑았으면 마지막 학생 뒤에 그대로 삽입
            if (number[i] == 0) {
                students[++last] = count;
            }
            // 학생이 0번을 뽑지 않았으면 해당 번호 만큼 앞으로 이동
            else {
                // 학생을 앞으로 이동시키기 위한 인덱스
                int index = last - number[i];

                // 앞으로 이동시켰을 때 해당 자리가 비어 있으면 번호를 그대로 삽입
                if (students[index] == 0) {
                    students[index] = count;
                }
                // 앞으로 이동시켰을 때 해당 자리에 사람이 있으면 전체적으로 왼쪽으로 밀어서 공간을 만들고 번호를 삽입
                else {
                    // 전체 번호를 왼쪽으로 미는 함수 호출
                    pushLeft(students, index);
                    // 왼쪽으로 밀어서 생긴 자리에 학생 번호 대입
                    students[index] = count;
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < size; i++) {
            if (students[i] != 0) {
                System.out.print(students[i] + " ");
            }
        }
    }
}
