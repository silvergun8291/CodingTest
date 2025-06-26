import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int [] diff = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            diff[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(diff);

        int result = 0;
        for (int i = 0; i < N - K; i++) {
            result += diff[i];
        }

        System.out.println(result);
    }
}