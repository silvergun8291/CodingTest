import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int target = Integer.parseInt(br.readLine());

        int left = 0;
        int right = n - 1;
        int count = 0;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                count++;
                left++;
                right--;
            }
            else if (sum > target) {
                right--;
            }
            else {
                left++;
            }
        }

        System.out.println(count);
    }
}