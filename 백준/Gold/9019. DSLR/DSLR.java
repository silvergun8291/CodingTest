import java.io.*;
import java.util.*;

public class Main {
    static class DSLR {
        int value;
        String operator;

        public DSLR(int value, String operator) {
            this.value = value;
            this.operator = operator;
        }
    }

    static int A, B;
    static boolean [] visited;

    static int D(int n) {
        return (n * 2) % 10000;
    }

    static int S(int n) {
        return n == 0 ? 9999:n - 1;
    }

    static int L(int n) {
        return ((n / 100) % 10) * 1000 + ((n / 10) % 10) * 100 + (n % 10) * 10 + (n / 1000);
    }

    static int R(int n) {
        return (n % 10) * 1000 + (n / 1000) * 100 + ((n / 100) % 10) * 10 + ((n / 10) % 10);
    }

    static String bfs() {
        Queue<DSLR> queue = new ArrayDeque<>();
        queue.offer(new DSLR(A, ""));
        visited[A] = true;

        while (!queue.isEmpty()) {
            DSLR dslr = queue.poll();
            int current = dslr.value;
            String operator = dslr.operator;

            if (current == B)
                return operator;

            int d = D(current);
            if (!visited[d]) {
                visited[d] = true;
                queue.offer(new DSLR(d, operator + "D"));
            }
            
            int s = S(current);
            if (!visited[s]) {
                visited[s] = true;
                queue.offer(new DSLR(s, operator + "S"));
            }
            
            int l = L(current);
            if (!visited[l]) {
                visited[l] = true;
                queue.offer(new DSLR(l, operator + "L"));
            }
            
            int r = R(current);
            if (!visited[r]) {
                visited[r] = true;
                queue.offer(new DSLR(r, operator + "R"));
            }
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];

            String operator = bfs();
            sb.append(operator).append("\n");
        }

        System.out.println(sb);
    }
}