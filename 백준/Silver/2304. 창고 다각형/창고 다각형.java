import java.io.*;
import java.util.*;

public class Main {
    static int [][] block;
    static int N;

    static int getMaxHeight() {
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            maxHeight = Math.max(maxHeight, block[i][1]);
        }

        return maxHeight;
    }

    static int [] getMaxCoordinate(int maxHeight) {
        int maxStart = 0;
        int maxEnd = 0;

        for (int i = 0; i < N; i++) {
            if (block[i][1] == maxHeight) {
                maxStart = i;
                break;
            }
        }

        for (int i = N-1; i >= 0; i--) {
            if (block[i][1] == maxHeight) {
                maxEnd = i;
                break;
            }
        }

        return new int [] {maxStart, maxEnd};
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        block = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            block[i][0] = Integer.parseInt(st.nextToken());
            block[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(block, (a, b) -> Integer.compare(a[0], b[0]));

        int maxHeight = getMaxHeight();
        int maxStart = getMaxCoordinate(maxHeight)[0];
        int maxEnd = getMaxCoordinate(maxHeight)[1];

        int left = 0;
        int right = N - 1;
        int leftStart = block[0][0];
        int leftHeight = 0;
        int rightStart = block[N-1][0];
        int rightHeight = 0;
        int area = 0;

        while (block[left][1] != maxHeight) {
            leftHeight = Math.max(leftHeight, block[left][1]);
            leftStart = Math.min(leftStart, block[left][0]);

            if (block[left][1] < block[left + 1][1]) {
                area += (block[left + 1][0] - leftStart) * leftHeight;
                leftStart = block[left + 1][0];
            }

            left++;
        }

        while (block[right][1] != maxHeight) {
            rightHeight = Math.max(rightHeight, block[right][1]);
            rightStart = Math.max(rightStart, block[right][0]);

            if (block[right][1] < block[right - 1][1]) {
                area += (rightStart - block[right - 1][0]) * rightHeight;
                rightStart = block[right - 1][0];
            }

            right--;
        }
        
        area += (block[maxEnd][0] - block[maxStart][0] + 1) * maxHeight;

        System.out.println(area);
    }
}
