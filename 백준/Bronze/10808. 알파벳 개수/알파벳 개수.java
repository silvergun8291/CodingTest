import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br. readLine();
        int [] alpha = new int [26];

        for (char c: str.toCharArray()) {
            alpha[c-'a']++;
        }

        for (int n: alpha) {
            System.out.print(n + " ");
        }
    }
}