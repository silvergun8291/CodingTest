import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());    // 종이의 가로 길이
        int ySize = Integer.parseInt(st.nextToken());    // 종이의 세로 길이

        int n = Integer.parseInt(br.readLine());        // 잘라야 하는 점선의 개수
        int area = 0;
        List<Integer> xCoordinate = new ArrayList<>();
        List<Integer> yCoordinate = new ArrayList<>();
        int maxWidth = 0;
        int maxHeight = 0;

        xCoordinate.add(0);
        yCoordinate.add(0);
        xCoordinate.add(xSize);
        yCoordinate.add(ySize);

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st2.nextToken());   // 자르는 방향
            int position = Integer.parseInt(st2.nextToken());    // 자르는 좌표

            if (direction == 0) {
                yCoordinate.add(position);
            }
            else if (direction == 1) {
                xCoordinate.add(position);
            }
        }

        Collections.sort(xCoordinate);
        Collections.sort(yCoordinate);

        int prevX = xCoordinate.get(0);
        for (int i = 1; i < xCoordinate.size(); i++) {
            int distance = Math.abs(xCoordinate.get(i) - prevX);

            if (maxWidth < distance) {
                maxWidth = distance;
            }

            prevX = xCoordinate.get(i);
        }

        int prevY = yCoordinate.get(0);
        for (int i = 1; i < yCoordinate.size(); i++) {
            int distance = Math.abs(yCoordinate.get(i) - prevY);

            if (maxHeight < distance) {
                maxHeight = distance;
            }

            prevY = yCoordinate.get(i);
        }

        area = maxWidth * maxHeight;
        System.out.println(area);
    }
}