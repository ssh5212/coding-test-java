import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 번째 줄
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 숫자 개수
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

        int[] s = new int[N + 1];
        // 두 번째 줄
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            s[i] = s[i - 1] + Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(s));
        for (int i = 0; i < M; i++) {
            // 나머지 줄
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(s[end] - s[start - 1]);

        }

    }
}