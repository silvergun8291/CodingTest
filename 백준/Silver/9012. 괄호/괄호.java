import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            // 괄호를 입력받음
            String bracket = br.readLine();
            boolean result = true;

            // 꺼낼 토큰이 남아있으면
            for (char c: bracket.toCharArray()) {
                // 열린 괄호이면
                if (c == '(')
                    // 스택에 삽입
                    stack.push(c);
                    // 닫힌 괄호이면
                else if (c == ')') {
                    // 스택이 비어있는지 확인하고 비어있지 않으면
                    if (!stack.isEmpty()) {
                        // 괄호가 짝이 맞는지 비교하여 결과를 result에 대입
                        result = stack.pop() == '(';
                    }
                    // 비어있다면 짝이 맞지 않는 것이기 때문에
                    else {
                        // result에 false 대입
                        result = false;
                        break;
                    }
                }
            }

            // 만약 스택에 남이있는 괄호가 있다면 규칙 위반
            if (!stack.isEmpty())
                result = false;

            if (result)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        System.out.println(sb);
    }
}
