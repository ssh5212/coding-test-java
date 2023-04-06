import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int ansX = 0;
        int ansY = 0;
        
        // 하나씩 받아오기
        for (int[] card : sizes) {
            // 두 축 중에서 긴 축을 가로로 지정
            int y = Math.min(card[0] , card[1]);
            int x = Math.max(card[0], card[1]);
            
            // 카드 중 가로/세로가 가장 긴 값 갱신
            ansX = Math.max(ansX, x);
            ansY = Math.max(ansY, y);
        }
        
        answer = ansX * ansY;

        return answer;
    }
}