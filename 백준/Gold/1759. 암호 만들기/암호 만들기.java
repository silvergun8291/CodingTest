import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char [] alpha;
    static List<char[]> result;

    static boolean checkSorted(char [] code, int length) {
        char [] tmp = new char[length];
        char [] tmp2 = new char[length];

        for (int i = 0; i < length; i++) {
            tmp[i] = code[i];
            tmp2[i] = code[i];
        }

        Arrays.sort(tmp);

        return Arrays.equals(tmp, tmp2);
    }

    static boolean checkAlpha(char [] code) {
        int count = 0;
        int count2 = 0;

        for (char c : code) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
            else {
                count2++;
            }
        }

        if (count >= 1 && count2 >= 2)
            return true;
        else
            return false;
    }

    static void bruteForce(int cnt, int start, char [] code) {
        if (cnt == L) {
            if (checkAlpha(code)) {
                char [] tmp = new char[L];

                for (int i = 0; i < L; i++) {
                    tmp[i] = code[i];
                }

                result.add(tmp);
            }

            return;
        }


        for (int i = start; i < C; i++) {
            code[cnt] = alpha[i];
            bruteForce(cnt + 1, i + 1, code);
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpha = new char[C];
        result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha);

        bruteForce(0, 0, new char[L]);

        for (char [] code : result) {
            sb.append(code).append("\n");
        }

        System.out.println(sb);
    }
}