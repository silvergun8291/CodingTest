import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        Set<Integer> fact = new HashSet<>();

        for (int i = 0; i < F; i++) {
            int n = Integer.parseInt(st.nextToken());
            fact.add(n);
        }

        List<List<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            List<Integer> participants = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                participants.add(Integer.parseInt(st.nextToken()));
            }

            parties.add(participants);
        }

        boolean updated;
        do {
            updated = false;
            
            for (List<Integer> part : parties) {
                if (!Collections.disjoint(fact, part)) {
                    for (int person: part) {
                        if (!fact.contains(person)) {
                            fact.add(person);
                            updated = true;
                        }
                    }
                }
            }
        } while (updated);

        int count = 0;

        for (List<Integer> part : parties) {
            if (Collections.disjoint(fact, part)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
