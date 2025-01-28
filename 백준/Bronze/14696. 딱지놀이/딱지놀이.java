import java.util.*;
import java.io.*;

public class Main {
    static int N;   // 딱지놀이 라운드 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int playerASize = Integer.parseInt(st.nextToken());
            int [] playerA = new int[4];

            for (int j = 0; j < playerASize; j++) {
                int pattern = Integer.parseInt(st.nextToken());
                playerA[pattern - 1]++;
            }

            st = new StringTokenizer(br.readLine());
            int playerBSize = Integer.parseInt(st.nextToken());
            int [] playerB = new int[4];

            for (int j = 0; j < playerBSize; j++) {
                int pattern = Integer.parseInt(st.nextToken());
                playerB[pattern - 1]++;
            }

            if (playerA[3] > playerB[3]) {
                result.append("A\n");
            }
            else if (playerA[3] < playerB[3]) {
                result.append("B\n");
            }
            else if (playerA[2] > playerB[2]) {
                result.append("A\n");
            }
            else if (playerA[2] < playerB[2]) {
                result.append("B\n");
            }
            else if (playerA[1] > playerB[1]) {
                result.append("A\n");
            }
            else if (playerA[1] < playerB[1]) {
                result.append("B\n");
            }
            else if (playerA[0] > playerB[0]) {
                result.append("A\n");
            }
            else if (playerA[0] < playerB[0]) {
                result.append("B\n");
            }
            else {
                result.append("D\n");
            }
        }

        System.out.println(result);
    }
}
