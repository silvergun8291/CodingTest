import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] numbers;
    static char[] selectedOperator;
    static int[] opCounts = new int[4]; // +, -, *, / 순서
    static int minResult;
    static int maxResult;

    static char getOpChar(int idx) {
        switch (idx) {
            case 0: return '+';
            case 1: return '-';
            case 2: return '*';
            case 3: return '/';
            default: throw new IllegalArgumentException();
        }
    }

    static void calculate() {
        int result = numbers[0];
        
        for (int i = 0; i < N-1; i++) {
            char op = selectedOperator[i];
            int num = numbers[i+1];
            
            switch (op) {
                case '+': result += num; break;
                case '-': result -= num; break;
                case '*': result *= num; break;
                case '/': result /= num; break;
            }
        }
        
        minResult = Math.min(minResult, result);
        maxResult = Math.max(maxResult, result);
    }

    static void backtrack(int depth) {
        if (depth == N-1) {
            calculate();
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (opCounts[i] == 0) continue;
            
            opCounts[i]--;
            selectedOperator[depth] = getOpChar(i);
            backtrack(depth + 1);
            opCounts[i]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            numbers = new int[N];
            selectedOperator = new char[N-1];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            opCounts[0] = Integer.parseInt(st.nextToken()); // +
            opCounts[1] = Integer.parseInt(st.nextToken()); // -
            opCounts[2] = Integer.parseInt(st.nextToken()); // *
            opCounts[3] = Integer.parseInt(st.nextToken()); // /
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            
            minResult = Integer.MAX_VALUE;
            maxResult = Integer.MIN_VALUE;
            backtrack(0);
            
            sb.append("#").append(tc).append(" ").append(maxResult - minResult).append("\n");
        }
        System.out.print(sb);
    }
}
