import java.io.*;
import java.util.*;

// n : 벽의 길이
// m : 롤러의 길이

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        // 칠해야 하는 곳은 true;
        boolean[] map = new boolean[n +  1];
        for (int s: section) {
            map[s] = true;
        }

        // System.out.println("n : " + n);
        // System.out.println("m : " + m);
        
        for(int i = 1; i <= n - m + 1; i++) {
            // System.out.println(Arrays.toString(map));
            // System.out.println(i);
            // 다시 칠해야 하는 부분이 나왔다면
            if (map[i] == true) {
                // 롤러의 길이만큼 다시 칠함
                for (int j = i; j < i + m; j++) {
                    // System.out.print(j + " ");
                    map[j] = false;
                }
                // System.out.println();
                answer++;
                i = i + m - 1;
            }
        }
        
        for (int i = n - m + 1; i <= n; i++) {
            if (map[i] == true) {
                answer++;
                break;
            }
        }
        
        // System.out.println("-----------");
        // System.out.println(Arrays.toString(map));
        return answer;
    }
}