import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (p1[i%p1.length] == answers[i]) answer1++;
            if (p2[i%p2.length] == answers[i]) answer2++;
            if (p3[i%p3.length] == answers[i]) answer3++;
        }
        
        // System.out.println(answer1);
        
        
        if (answer1 == answer2 && answer1 == answer3) {
            answer = new int[3];
            answer[0] = 1;
            answer[1] = 2;
            answer[2] = 3;
        } else if (Math.max(answer1, answer3) == answer1 && answer1 == answer2) {
            answer = new int[2];
            answer[0] = 1;
            answer[1] = 2;
        } else if (Math.max(answer1, answer2) == answer2 && answer2 == answer3) {
            answer = new int[2];
            answer[0] = 2;
            answer[1] = 3;
        } else if (Math.max(answer1, answer2) == answer1 && answer1 == answer3) {
            answer = new int[2];
            answer[0] = 1;
            answer[1] = 3;
        } else {
            answer = new int[1];
            int now = Math.max(Math.max(answer1, answer2), answer3);
            if (answer1 == now) {
                answer[0] = 1;
            } else if (answer2 == now) {
                answer[0] = 2;
            } else {
                answer[0] = 3;
            }
        }
        
        return answer;
    }
}