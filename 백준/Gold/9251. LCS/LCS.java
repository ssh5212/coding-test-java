import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		String N = "0" + st.nextToken();

		st = new StringTokenizer(br.readLine());
		String M = "0" + st.nextToken();
		
		int[][] dp = new int[N.length()][M.length()];
		
		for (int i = 1; i < N.length(); i++) {
			for (int j = 1; j < M.length(); j++) {
				if (N.charAt(i) == M.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 
				}
			}
		}
		
		System.out.println(dp[N.length() - 1][M.length() - 1]);
	}
}