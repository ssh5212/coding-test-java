import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	static BigInteger[] dp;   
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		dp = new BigInteger[n + 2];
		
		dp[0] = BigInteger.valueOf(0);
		dp[1] = BigInteger.valueOf(1);
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		
		System.out.println(dp[n]);
		
	}
}