import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int N = 4;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            if (x1 > p2 || x2 > p1 || y2 >q1 || y1 > q2)
                result.append("d\n");
            else if ((p1 == x2 && q1 == y2) || (x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && y1 == q2))
                result.append("c\n");
            else if ((p2 == x1) || (p1 == x2) || (q1 == y2) || (y1 == q2))
                result.append("b\n");
            else
                result.append("a\n");
        }

        System.out.println(result);
    }
}