import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int R = A * B * C;
        String sR = R + "";
        int [] nums = new int[10];

        for (char c: sR.toCharArray()) {
            int n = c - '0';
            nums[n]++;
        }
        
        for (int n: nums) {
            System.out.println(n);
        }
    }
}