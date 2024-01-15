import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[H + 2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			if (i % 2 == 0) {
				arr[1] += 1;
				arr[now + 1] += -1; 
			} else {
				arr[H - now + 1] += 1;
				arr[H + 1] -= 1;
			}
		}
		
		int answer = Integer.MAX_VALUE;
		int count = 0;
		int[] s = new int[H + 2];
		for (int i = 1; i < s.length - 1; i++) {
			s[i] = s[i - 1] + arr[i];

			if (answer > s[i]) {
				answer = s[i];
				count = 1;
			} else if (answer == s[i]) {
				count += 1;
			}
		}
		
		System.out.print(answer + " " + count);
	
	}

}