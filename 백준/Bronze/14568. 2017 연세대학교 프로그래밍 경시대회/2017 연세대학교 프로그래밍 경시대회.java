import java.io.*;
import java.util.*;

// 남규 >= 영훈 + 2
// 택희 : 택희 % 2 != 0
// 남는 사탕은 없어야 함

// if 영훈 != 0

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 0; i <= N; i++) { // 남규
            for (int j = 0; j <= N; j++) { // 영훈
                for (int k = 0; k <= N - 1; k++) { // 택희
                    if ( (i + j + k == N) && (i >= j + 2) && (k % 2 == 0) && (i != 0 && j != 0 && k != 0) ) {
                        // System.out.println(i + " " + j + " " + k);
                        count++;
                    }
                }
            }
        }
    System.out.println(count);
    }

}