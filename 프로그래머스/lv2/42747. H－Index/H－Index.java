import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = citations.length;
        
        int no = 1;
        Arrays.sort(citations);
        
        for (int i = citations.length-1; i >= 0; i--) {
            System.out.println(no + " : " + citations[i]);
            // citations[i] : 나의 인용 수
            if (no == citations[i]) {
                answer = no;
                System.out.println(answer);
                
                break;
            } else if (no > citations[i]) {
                answer = no - 1;
            } else {                
                no++;
            }
            
        }
        
        
        
        return answer;
    }
}