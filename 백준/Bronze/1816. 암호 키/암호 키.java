import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 번째 줄
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            Long num = Long.parseLong(st.nextToken());

            for (int j = 2; j < 1000001; j++) {
                if (num % j == 0) {
                    System.out.println("NO");
                    break;
                }
                if (j == 1000000) {
                    System.out.println("YES");
                }
            }
        }
    }
}