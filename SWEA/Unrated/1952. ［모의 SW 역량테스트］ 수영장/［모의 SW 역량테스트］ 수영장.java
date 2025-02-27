import java.util.*;
import java.io.*;

public class Solution {
    static int [] plans;                // 12개월 이용 계획
    static int [] passes;
    static int [] prices;
    static List<Integer> totalPrices;

    static void backtracking(int start, int end, int price) {
        if (start > end) {
            totalPrices.add(price);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (i == 0)
                backtracking(start+1, end, price+(prices[0] * plans[start]));
            else if (i == 3)
                backtracking(12, end, price + prices[3]);
            else
                backtracking(start+passes[i], end, price+prices[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            plans = new int[12];
            passes = new int[] {1, 1, 3, 12};
            prices = new int[4];
            totalPrices = new ArrayList<>();

            // 이용권 가격을 입력받음
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            // 12개월 이용계획을 입력받음
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                plans[i] = Integer.parseInt(st.nextToken());
            }

            int start = 0;
            int end = 0;

            // 수영 시작 달을 구함
            for (int i = 0; i < 12; i++) {
                if (plans[i] != 0) {
                    start = i;
                    break;
                }
            }

            // 수영 종료 달을 구함
            for (int i = 11; i >= 0; i--) {
                if (plans[i] != 0) {
                    end = i;
                    break;
                }
            }

            backtracking(start, end, 0);

            Collections.sort(totalPrices);
            sb.append("#").append(tc).append(" ").append(totalPrices.get(0)).append("\n");
        }

        System.out.println(sb);
    }
}
