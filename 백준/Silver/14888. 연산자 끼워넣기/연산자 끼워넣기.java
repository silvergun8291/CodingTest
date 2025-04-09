import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int [] numbers;
    static char [] selectOper;
    static char [] operators;
    static int [] operatorFreq;
    static boolean [] visited;
    static int max, min;

    static void dfs(int cnt, int r) {
        if (cnt == r) {
            int result = getCalc();

            if (result > max) {
                max = result;
            }
            if (result < min) {
                min = result;
            }

            return;
        }

        for (int i = 0; i < operators.length; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            selectOper[cnt] = operators[i];
            dfs(cnt + 1, r);
            visited[i] = false;
        }
    }

    static int getCalc() {
        int a = numbers[0];
        int b = numbers[1];
        char op = selectOper[0];

        int first = calc(a, b, op);

        for (int i = 2; i <= selectOper.length; i++) {
            first = calc(first, numbers[i], selectOper[i-1]);
        }

        return first;
    }

    static int calc(int a, int b, char op) {
        int result = 0;

        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        selectOper = new char[N-1];
        operatorFreq = new int[4];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            operatorFreq[i] = Integer.parseInt(st.nextToken());
            sum += operatorFreq[i];
        }

        operators = new char[sum];
        int idx = 0;

        for (int i = 0; i < operatorFreq[0]; i++) {
            operators[idx++] = '+';
        }

        for (int i = 0; i < operatorFreq[1]; i++) {
            operators[idx++] = '-';
        }

        for (int i = 0; i < operatorFreq[2]; i++) {
            operators[idx++] = '*';
        }

        for (int i = 0; i < operatorFreq[3]; i++) {
            operators[idx++] = '/';
        }

        visited = new boolean[sum];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        dfs(0, N-1);

        System.out.println(max);
        System.out.println(min);
    }
}
