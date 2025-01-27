import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_SIZE = 1001;   // 평면의 칸수
    static int [][] board = new int[MAX_SIZE][MAX_SIZE];  // 평면
    static int N;   // 색종이의 개수

    static void drawRect(int x, int y, int width, int height, int val) {
        for (int i = y; i < y + height; i++) {
            for (int j = x; j < x + width; j++) {
                board[i][j] = val;
            }
        }
    }

    static int calcArea(int val) {
        int area = 0;

        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (board[i][j] == val) {
                    area += 1;
                }
            }
        }

        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            drawRect(x, y, width, height, i+1);
        }

        for (int i = 0; i < N; i++) {
            int area = calcArea(i+1);
            System.out.println(area);
        }
    }
}
