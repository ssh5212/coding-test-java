import java.io.*;
import java.util.*;

class Solution {
    
    static int[] lh;
    static int[] rh;
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        lh = new int[] {3, 0};
        rh = new int[] {3, 2};
        
        
        for (int n : numbers) {
            
            if (n == 1) {
                answer += "L";
                lh[0] = 0;
                lh[1] = 0;
            } else if (n == 4) {
                answer += "L";
                lh[0] = 1;
                lh[1] = 0;
            } else if (n == 7) {
                answer += "L";
                lh[0] = 2;
                lh[1] = 0;
            }
            else if (n == 3) {
                answer += "R";
                rh[0] = 0;
                rh[1] = 2;
            } else if (n == 6) {
                answer += "R";
                rh[0] = 1;
                rh[1] = 2;
            } else if (n == 9) {
                answer += "R";
                rh[0] = 2;
                rh[1] = 2;
            }
            
            else {
                int num = n - 1;
                if (num == -1) {
                    num = 10;
                }
                int row = num / 3;
                int col = num % 3;

                int lLength = Math.abs(row - lh[0]) + Math.abs(col - lh[1]);
                int rLength = Math.abs(row - rh[0]) + Math.abs(col - rh[1]);
                System.out.println( num + " => " + lLength + " : " + rLength);

                if (lLength < rLength) {
                    lh[0] = row;
                    lh[1] = col;
                    answer += "L";
                } else if (lLength > rLength) {
                    rh[0] = row;
                    rh[1] = col;
                    answer += "R";
                } else {
                    if (hand.equals("left")) {
                        lh[0] = row;
                        lh[1] = col;
                        answer += "L";
                    } else {
                        rh[0] = row;
                        rh[1] = col;
                        answer += "R";
                    }
                }
            }

        }
        
        return answer;
    }
    
}