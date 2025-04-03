import java.io.*;
import java.util.*;

public class Main {
    static int N = 9;
    static int[][] sudoku;

    static void findAvailable(int y, int x, boolean[] available) {
        Arrays.fill(available, true);

        for (int i = 0; i < N; i++) {
            if (sudoku[y][i] != 0) available[sudoku[y][i]] = false;
            if (sudoku[i][x] != 0) available[sudoku[i][x]] = false;
        }

        for (int i = (y / 3) * 3; i < (y / 3) * 3 + 3; i++) {
            for (int j = (x / 3) * 3; j < (x / 3) * 3 + 3; j++) {
                if (sudoku[i][j] != 0) available[sudoku[i][j]] = false;
            }
        }
    }

    static boolean dfs(int y, int x) {
        if (y == N) {
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(sudoku[i][j]);
                }
                sb.append("\n");
            }
            
            System.out.print(sb);
            return true;
        }

        if (x == N) return dfs(y + 1, 0);

        if (sudoku[y][x] == 0) {
            boolean[] available = new boolean[N + 1];
            findAvailable(y, x, available);

            for (int num = 1; num <= N; num++) {
                if (available[num]) {
                    sudoku[y][x] = num;
                    if (dfs(y, x + 1)) return true;
                }
            }

            sudoku[y][x] = 0;
            return false;
        }

        return dfs(y, x + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();

            for (int j = 0; j < N; j++) {
                sudoku[i][j] = Integer.parseInt(row.substring(j, j + 1));
            }
        }

        dfs(0, 0);
    }
}
