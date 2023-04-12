import java.io.*;
import java.util.*;

class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // 0번은 마지막 출력 시 제외하고 계산해야 함
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);
        
        // 옷을 잃어버린 학생은 -1
        for(int l:lost) {
            arr[l] -= 1;
        }
        
        // 여벌을 가져온 학생은 +1
        for(int r:reserve) {
            arr[r] += 1;
        }
        
        for(int i = 2; i < arr.length; i++) {
            // 내가 두 개 들고 있는데
            if(arr[i] == 2) {
                // 앞이 0이고, 앞앞이 2라면 (앞앞이 줄 수 있다면)
                if (arr[i-1] == 0 && arr[i-2] == 2) {
                    continue;
                }
                // 앞이 0이고, 앞앞이 0or1라면 (나밖에 줄 수 없다면)
                else if (arr[i-1] == 0 && (arr[i-2] == 1 || arr[i-2] == 0)) {
                    arr[i-1] = 1;
                    arr[i] = 1;
                }
            }
        }
        
        for(int i = 1; i < arr.length - 1; i++) {
            // 내가 2인데 내 뒤가 0이라면
            if (arr[i] == 2 && arr[i + 1] == 0) {
                arr[i] = 1;
                arr[i+1] = 1;
            }
        }
        
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                answer++;
            }
        }
        
        return answer;
    }
}