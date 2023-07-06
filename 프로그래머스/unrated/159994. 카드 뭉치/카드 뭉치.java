import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int idx1 = 0;
        int idx2 = 0;
        
        for (int i = 0; i < goal.length; i++) {
            if (idx1 < cards1.length && cards1[idx1].equals(goal[i]) ) {
                idx1 = idx1 + 1;
                continue;
            } 
            else if (idx2 < cards2.length && cards2[idx2].equals(goal[i]) ) {
                idx2 = idx2 + 1;
                continue;
            } 
            else {
                answer = "No";
                break;
            }
        }
        
        System.out.println(Arrays.toString(cards1));
        System.out.println(Arrays.toString(cards2));
        
        return answer;
    }
}