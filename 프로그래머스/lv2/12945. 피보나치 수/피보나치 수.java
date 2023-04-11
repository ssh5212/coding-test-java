import java.io.*;
import java.util.*;

class Solution {
    
    static int[] arr;
    
    public int solution(int n) {
        int answer = 0;
        
        arr = new int[n+1];
        Arrays.fill(arr, -1);
        // Sol1
//         arr[0] = 0;
//         arr[1] = 1;
//         arr[2] = 1;
        
//         for (int i = 3; i <= n; i++) {
//             arr[i] = (arr[i-1] + arr[i-2])%1234567;
//         }
//          answer = arr[n];
        
        // Sol2
        answer = fibo(n);
        
        return answer;
    }
    
    static int fibo(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }
        
        if (arr[n] != -1) {
            return arr[n];
        }
        
        return arr[n] = (fibo(n-1) + fibo(n-2))%1234567;
        
    }
}