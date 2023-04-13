import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1] ; // end 기준으로 오름
        });
        
        Integer now = null;
        
        for(int[] route:routes) {
            // 아모고토 없었다면 첫번째 끝을 집어 넣기
            if (now == null) {
                now = route[1]; 
                answer++;
                continue;
            }
            
            // route의 범위를 벗어난다면 (겹치지 않는다면)
            if (route[0] > now || now > route[1]) {
                answer++;
                now = route[1];
            }
            
        }
        
        
        return answer;
    }
}