class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            boolean flag = true;
            int day = startday - 1;
            int rush = 0;
            
            if ((schedules[i] % 100) + 10 >= 60) {
                int hour = ((schedules[i] % 100) + 10) / 60 * 100;
                int min = schedules[i] - 50;
                rush += hour + min;
            } else {
                rush = schedules[i] + 10;
            }
            
            System.out.println("출근 인정 시간 : " + rush);    
            
            for (int j = 0; j < 7; j++) {
                if (day > 4) {
                    day = (day + 1) % 7;
                    continue;
                }

                if (timelogs[i][j] > rush) {
                    flag = false;
                    break;
                }
                
                day = (day + 1) % 7;
            }
            
            if (flag)
                answer++;
        }
        
        return answer;
    }
}