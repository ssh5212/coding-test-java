import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 첫 번째 줄
        int N = Integer.parseInt(st.nextToken()); // 개 월수
        
        // 등급별 저장
        int[] arr = new int[4];
        String lev;
        
        // 두 번째 줄
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 세 번째 줄
        st = new StringTokenizer(br.readLine());
        lev = st.nextToken();
        
        int pre = 0;
        
        int[] ans = new int[N + 1];
        
        for (int i = 1; i < ans.length; i++) {
            if (lev.charAt(i - 1) == 'B') {
                ans[i] = arr[0] - 1 - ans[i-1] ;
            } else if(lev.charAt(i - 1) == 'S') {
                ans[i] = arr[1] - 1 - ans[i-1];
            } else if(lev.charAt(i - 1) == 'G') {
                ans[i] = arr[2] - 1 - ans[i-1];
            } else if(lev.charAt(i - 1) == 'P') {
                ans[i] = arr[3] - 1 - ans[i-1];
            } else if(lev.charAt(i - 1) == 'D') {
                ans[i] = arr[3];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < ans.length; i++) {
            answer += ans[i];
        }
//        System.out.println(Arrays.toString(ans));
        System.out.println(answer);
        
    }
}