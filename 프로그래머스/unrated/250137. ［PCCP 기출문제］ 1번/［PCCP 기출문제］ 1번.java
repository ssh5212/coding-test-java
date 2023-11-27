import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = -1;
        
        // System.out.println(attacks[attacks.length - 1][0]);
        int lastTime = attacks[attacks.length - 1][0]; // 마지막 수행 시간
        int tempIndex = 0;
        int nowHealth = health;
        int healTime = 0;
        for (int i = 1; i <= lastTime; i++) {
            // 현재 시간과 공격 시간이 같다면
            if (i == attacks[tempIndex][0]) {
                nowHealth = nowHealth - attacks[tempIndex][1];
                tempIndex = tempIndex + 1;
                healTime = 0;
                
                // 체력이 0 이하라면
                if (nowHealth <= 0) {
                    answer = -1;
                    break;
                }
            }
            // 공격 타임이 아니라면
            else {
                // 일반 회복
                nowHealth = nowHealth + bandage[1];
                healTime = healTime + 1;
                // 연속 힐 시간이 시전시간인 경우
                if (healTime == bandage[0]) {
                    nowHealth = nowHealth + bandage[2];
                    healTime = 0;
                }
                
                if (nowHealth > health) {
                    nowHealth = health;
                }
            }
            
            // 마지막이라면
            if (i == lastTime) {
                answer = nowHealth;
            }
        }
         
        return answer;
    }
}