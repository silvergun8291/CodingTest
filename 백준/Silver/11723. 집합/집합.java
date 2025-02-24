import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int bitMask = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int value = 0;

            // 명령에 정수가 필요한 경우 처리 (add, remove, check, toggle)
            if (st.hasMoreTokens()) {
                value = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "add":
                    bitMask |= (1 << value);
                    break;
                case "remove":
                    bitMask &= ~(1 << value);
                    break;
                case "check":
                    sb.append((bitMask & (1 << value)) != 0 ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    bitMask ^= (1 << value);
                    break;
                case "all":
                    bitMask = (1 << 21) - 1;  // 1부터 20까지 모두 포함
                    break;
                case "empty":
                    bitMask = 0;
                    break;
            }
        }

        System.out.println(sb);
    }
}