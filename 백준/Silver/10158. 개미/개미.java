import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w;
        int h;
        int [] coordinates = new int[2];
        int t;

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        coordinates[0] = Integer.parseInt(st.nextToken());
        coordinates[1] = Integer.parseInt(st.nextToken());

        t = Integer.parseInt(br.readLine());

        int x = w - Math.abs(w - (coordinates[0] + t) % (2 * w));
        int y = h - Math.abs(h - (coordinates[1] + t) % (2 * h));

        System.out.println(x + " " + y);
    }
}