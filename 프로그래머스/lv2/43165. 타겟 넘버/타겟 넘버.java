import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        boolean[] v = new boolean[numbers.length]; 
        
        dfs(numbers, target, v, 0);
        
        return answer;
    }
    
    public void dfs (int[] numbers, int target, boolean[] v, int cnt) {
        // basis part
        if (cnt == numbers.length) {
            int now = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (v[i] == true) {
                    now = now + numbers[i];
                } else {
                    now = now - numbers[i];
                }
            }
        
            if (now == target) {
                answer++;
            }
            
            return;
        }
        
       // inductive part
        v[cnt] = true; 
        dfs(numbers, target, v, cnt + 1);
        v[cnt] = false; 
        dfs(numbers, target, v, cnt + 1);
    }
}