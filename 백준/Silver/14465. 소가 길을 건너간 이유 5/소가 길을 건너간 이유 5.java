import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 연속한 신호등
		int B = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1]; // 정상 0, 비정상 1
		for (int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			arr[now] = 1;
		}
		
		int[] s = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			s[i] = arr[i] + s[i - 1];
		}
		
		
		int answer = Integer.MAX_VALUE;

		for (int i = 1; i <= N - K + 1; i++) {
			int nowAns = s[i + K - 1] - s[i - 1];
			answer = Math.min(nowAns, answer);
			
		}
		
		System.out.println(answer);
		
		
		
	}

}