import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;  //  스위치의 개수
        int [] lights;  // 전구
        int S;  // 학생 수

        N = Integer.parseInt(br.readLine());
        lights = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        for (int i = 0; i < S; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st2.nextToken());
            int number = Integer.parseInt(st2.nextToken());

            if (gender == 1) {
                int index = number;
                while(index <= N) {
                    if (lights[index] == 0) {
                        lights[index] = 1;
                    }
                    else if (lights[index] == 1) {
                        lights[index] = 0;
                    }

                    index += number;
                }
            }
            else if (gender == 2) {
                if (lights[number] == 0) {
                    lights[number] = 1;
                }
                else if (lights[number] == 1) {
                    lights[number] = 0;
                }

                int range = 1;
                while((number - range) > 0 && (number + range) < lights.length) {
                    if(lights[number + range] == lights[number - range]) {
                        if(lights[number + range] == 0) {
                            lights[number + range] = 1;
                            lights[number - range] = 1;
                        }
                        else if(lights[number + range] == 1) {
                            lights[number + range] = 0;
                            lights[number - range] = 0;
                        }
                        range++;
                    }
                    else {
                        break;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(lights[i] + " ");
            if (i % 20 == 0)
                System.out.println();
        }
    }
}