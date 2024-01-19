import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] a = new int[N + 1];
		int M = Integer.parseInt(st.nextToken());
		int[] s = new int[N + 1];
		
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			s[i] = s[i - 1] + a[i];
		}
		
		int lt = 1;
		int rt = 1;
		while (rt <= N) {
			if (s[rt] - s[lt - 1] == M) {
				answer++;
				lt++;
				rt++;
			} else if (s[rt] - s[lt - 1] < M) {
				rt++;
			} else {
				lt++;
			}
		}
		System.out.println(answer);
		
	}

}