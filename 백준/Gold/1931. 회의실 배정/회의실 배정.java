import java.util.*;
import java.io.*;

public class Main {
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            return this.end != o.end ? this.end - o.end : this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetings);
        Meeting prev = meetings[0];
        int count = 1;

        for (int i = 1; i < meetings.length; i++) {
            if (prev.end <= meetings[i].start) {
                prev = meetings[i];
                count++;
            }
        }

        System.out.println(count);
    }
}