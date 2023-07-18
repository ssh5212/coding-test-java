// i : 배열 시작 인덱스 (1부터 시작)
// j : 배열 끝 인덱스 (포함)
// k : 자른 배열의 정렬 후 위치 (1부터 시작)

import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        
        for (int a = 0; a < commands.length; a++) {
            int i = commands[a][0] - 1;
            int j = commands[a][1];
            int k = commands[a][2] - 1;
            // System.out.println(i);
            // System.out.println(j);
            // System.out.println(k);
            
            int[] splitArray = new int[j - i];
            for (int b = 0; b < splitArray.length; b++) {
                splitArray[b] = array[i + b];
            }
            // System.out.println(Arrays.toString(splitArray));
            Arrays.sort(splitArray);
            // System.out.println(Arrays.toString(splitArray));
            
            // 역정렬
            // Arrays.sort(splitArray, Collections.reverseOrder());
            // System.out.println(Arrays.toString(splitArray));
            
            // System.out.println(splitArray[k]);
            answer[a] = splitArray[k];
            
        } // [E] for(a)
        
        
        
        
        return answer;
    }
}