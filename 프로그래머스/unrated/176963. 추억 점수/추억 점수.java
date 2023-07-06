
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        answer = new int[photo.length];
        
        // System.out.println("name" + Arrays.toString(name));
        // System.out.println("yearning" + Arrays.toString(yearning));
        // System.out.println("photo" + Arrays.toString(photo[1]));
        
        for (int i = 0; i < photo.length; i++) {
            int inner_answer = 0;
            for (int j = 0; j < photo[i].length; j++) {
                for (int k = 0; k < name.length; k++) {
                    if (photo[i][j].equals(name[k])) {
                        inner_answer += yearning[k];
                    }
                }
            }
            answer[i] = inner_answer;
        }
        
        
        return answer;
    }
}