import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static HashSet<Integer> A = new HashSet<>();
    static HashSet<Integer> B = new HashSet<>();
    static HashSet<Integer> C = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            A.add(tmp);
            C.add(tmp);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }


        C.removeAll(B);
        B.removeAll(A);

        System.out.println(C.size() + B.size());
    }
}