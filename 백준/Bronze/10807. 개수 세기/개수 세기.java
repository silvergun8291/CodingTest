import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());

        int count = 0;

        for (int n: numbers) {
            if (n == target) {
                count++;
            }
        }

        System.out.println(count);
    }
}
