import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			System.out.println(recursive(M, N));
		}
		
	}
	
	static int recursive(int m, int n) {

		if (dp[m][n] > 0) {
			return dp[m][n];
		}
		if (m == n || n == 0) {
			return dp[m][n] = 1;
		}
		
		// 조합 공식 (m-1)C(n-1) + (m-1)C(n) 
		return dp[m][n] = recursive(m - 1, n - 1) + recursive(m - 1, n);
	}

}