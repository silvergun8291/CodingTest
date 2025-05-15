/**
 * 아이디어 : 이분 탐색으로 범위를 좁혀가며 공유기 배치가 가능한 인접한 두 공유기 사이의 최대 거리를 구함
 * 시간 :
 * 메모리 :
 * 난이도 : 상
 */

import java.io.*;
import java.util.*;

public class Main {
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 집의 개수를 입력받음
        int M = Integer.parseInt(st.nextToken());   // 공유기의 개수를 입력받음

        house = new int[N]; // 집의 위치를 저장하는 배열

        // 집의 위치를 입력받음
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        // 이분 탐색을 위해 house 배열 정렬
        Arrays.sort(house);

        int low = 1;    // 공유기를 배치하는 최소 거리
        int high = house[N - 1] - house[0] + 1;    // 공유기를 배치하는 최대 거리

        while (low < high) {
            int mid = (low + high) / 2;    // 공유기를 배치하는 고정거리

            // 해당 거리를 기준으로 공유기를 배치했을 때 공유기 개수 보다 적게 배치할 수 있다면
            if (countRouter(mid) < M) {
                high = mid; // 공유기 배치 최대 거리를 mid로 세팅
            } else {    // 공유기 개수 이상으로 해당 거리를 기준으로 배치가 가능하면
                low = mid + 1;  // 공유기 배치 최소 거리를 mid+1로 세팅
            }
        }

        System.out.println(low - 1);    // 인접한 공유기 사이의 최대 거리를 출력
    }

    // 배치 가능한 공유기 개수를 반환하는 함수
    static int countRouter(int distance) {
        int count = 1;          // 첫번째 집은 반드시 배치
        int last = house[0];    // 최종에 배치된 공유기의 위치

        // 반복문을 돌며 설치 가능한 공유기 개수 카운트
        for (int i = 1; i < house.length; i++) {
            int location = house[i];    // 집의 좌표

            // 집의 좌표 - 최종 공유기가 배치된 공유기 위치가 distance보다 크면
            if (location - last >= distance) {
                // 공유기 설치 가능
                count++;            // 설치된 공유기 값 1 증가
                last = location;    // 최종 공유기의 위치를 집의 좌표로 증가
            }
        }

        return count;   // 공유기 개수 반환
    }
}
