import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static char [] operators;
    static int [] numbers;
    static char [] selectedOperator;
    static int [] opCounts;
    static List<Integer> result;

    static void calc() {
        ArrayDeque<Integer> numDeque = new ArrayDeque<>();
        ArrayDeque<Character> operatorDeque = new ArrayDeque<>();

        for (int number : numbers) {
            numDeque.addLast(number);
        }

        for (char c : selectedOperator) {
            operatorDeque.addLast(c);
        }

        while(!operatorDeque.isEmpty()) {
            int a = numDeque.removeFirst();
            int b = numDeque.removeFirst();
            char op = operatorDeque.removeFirst();
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

            numDeque.addFirst(result);
        }

        result.add(numDeque.removeFirst());
    }

    static char getOp(int i) {
        if (i == 0)
            return '+';
        else if (i == 1)
            return '-';
        else if (i == 2)
            return '*';
        else
            return '/';
    }

    static void perm(int cnt) {
        if (cnt == N-1) {
            calc();
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (opCounts[i] == 0)
                continue;

            opCounts[i]--;
            selectedOperator[cnt] = getOp(i);
            perm(cnt + 1);
            opCounts[i]++;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            opCounts = new int[4];
            selectedOperator = new char[N-1];
            result = new ArrayList<>();
            numbers = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++) {
                int count = Integer.parseInt(st.nextToken());
                opCounts[i] = count;
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            perm(0);

            Collections.sort(result);
            int diff = Math.abs(result.get(0) - result.get(result.size()-1));
            sb.append("#").append(tc).append(" ").append(diff).append("\n");
        }

        System.out.println(sb);
    }
}