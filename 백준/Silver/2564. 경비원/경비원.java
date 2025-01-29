import java.io.*;
import java.util.*;

public class Main {
    static int width;
    static int height;
    static int [] map;

    static int findDong(int dong) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] == dong)
                return i;
        }

        return -1;
    }

    static int calcDistance(int target, int dong) {
        int distance = 0;
        int targetX = -1;

        for (int i = 0; i < map.length; i++) {
            if (map[i] == target) {
                targetX = i;
                break;
            }
        }

        if (targetX != -1) {
            int right = Math.abs(targetX - dong);
            int left;

            if (dong > targetX) {
                left = map.length - dong + targetX;
            }
            else {
                left = map.length - targetX + dong;
            }

            distance = Math.min(left, right);
        }

        return distance;
    }

    static void setCoordinates(int direction, int distance, int store) {
        if (direction == 1) {
            map[distance - 1] = store;
        }
        else if (direction == 2) {
            map[width + height + width - distance - 1] = store;
        }
        else if (direction == 3) {
            map[width + width + height + height - distance - 1] = store;
        }
        else if (direction == 4) {
            map[width + distance - 1] = store;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        map = new int[(width * 2) + (height * 2)];

        int N = Integer.parseInt(br.readLine());
        int sumOfDistance = 0;

        for (int i = 0; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            setCoordinates(direction, distance, i+1);
        }

        int dong = findDong(N+1);
        for (int i = 0; i < N; i++) {
            sumOfDistance += calcDistance(i + 1, dong);
        }

        System.out.println(sumOfDistance);
    }
}