import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char [] word = st.nextToken().toCharArray();
            char [] word2 = st.nextToken().toCharArray();

            Arrays.sort(word);
            Arrays.sort(word2);

            boolean check = true;
            for (int j = 0; j < word.length; j++) {
                if (word[j] != word2[j]) {
                    check = false;
                    break;
                }
            }

            sb.append(check ? "Possible" : "Impossible").append("\n");
        }

        System.out.println(sb);
    }
}