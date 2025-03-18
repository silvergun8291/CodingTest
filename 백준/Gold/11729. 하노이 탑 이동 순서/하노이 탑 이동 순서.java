import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int moveCount = 0;

    static void hanoi(int N, int start, int mid, int to) {
        if (N == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            moveCount++;
            return;
        }

        hanoi(N-1, start, to, mid);
        sb.append(start).append(" ").append(to).append("\n");
        moveCount++;
        hanoi(N-1, mid, start, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);

        System.out.println(moveCount);
        System.out.println(sb);
    }
}
