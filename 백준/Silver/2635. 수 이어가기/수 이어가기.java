import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder numbers = new StringBuilder();

        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        for (int i = n; i >= n / 2; i--) {
            StringBuilder sb = new StringBuilder();

            sb.append(n).append(" ");
            int first = n;
            int second = i;

            while (second >= 0) {
                sb.append(second).append(" ");
                int tmp = first;
                first = second;
                second = tmp - second;
            }

            if (numbers.toString().length() < sb.toString().length())
                numbers = sb;
        }

        String[] result = numbers.toString().split(" ");
        System.out.println(result.length);

        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
