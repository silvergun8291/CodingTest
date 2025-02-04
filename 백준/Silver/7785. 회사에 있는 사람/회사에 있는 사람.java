import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, String> workers = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            workers.put(name, status);
        }

        List<String> insideWorkers = new ArrayList<>();
        for (String worker: workers.keySet()) {
            if (workers.get(worker).equals("enter")) {
                insideWorkers.add(worker);
            }
        }

        insideWorkers.sort(Collections.reverseOrder());
        for (String worker: insideWorkers) {
            System.out.println(worker);
        }
    }
}