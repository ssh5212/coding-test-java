import java.io.*;
import java.util.*;

public class Main {
	static int answer;

	static long[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp = new long[10 + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
//		dp[4] = 7;
//		dp[5] = 13;
		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			// 1. 완탐
			answer = 0;
//			recursive(n, 0);
//			System.out.println(answer);

			// 2. 하향식
//			recursiveDown(n);

			// 3. 상향식
			System.out.println(dp[n]);
		}

	}

	private static int recursiveDown(int n) {
//		if (n == 0) 
//			return dp[n];
//		
//		int n3 = 
//		if(n >= 3) {
//			n3 
//		}
		return 0;

	}

	private static void recursive(int n, int cnt) {
		if (cnt == n) {
			answer++;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			if (cnt + i <= n) {
				recursive(n, cnt + i);
			}
		}

	}

}