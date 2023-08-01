import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 번째 줄 : N K
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 온도를 측정한 전체 날짜의 수 == 두 번째 줄의 숫자 수
        int K = Integer.parseInt(st.nextToken()); // 연속적인 날짜의 수

        int[] s = new int[N+1]; // 누적합

        // 두 번째 줄 : 전체 날짜의 온도
        st = new StringTokenizer(br.readLine());


        for (int i = 1; i <= N; i++) {
            s[i] = s[i-1] + Integer.parseInt(st.nextToken());
        }

        // System.out.println(Arrays.toString(prefix));

        int answer = Integer.MIN_VALUE;

        for (int i = K; i <= N; i++) {
            answer = Math.max(answer, s[i] - s[i - K]);
        }

        System.out.println(answer);
    }
}