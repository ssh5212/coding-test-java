import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] s = new int[N + 1];
		
		// 누적합
		for (int i = 1; i < N + 1; i++) {
			s[i] = s[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		int answer = Integer.MAX_VALUE;
		int lt = 1;
		int rt = 1;
		while (!(lt == N + 1 || rt == N + 1)) {
			int now = s[rt] - s[lt - 1];
			if (now >= S) {
				answer = Math.min(answer, rt - lt + 1);
//				System.out.println(lt + " " + rt);
				lt++;
			} else {
				rt++;
			}
		}
		
		if (answer == Integer.MAX_VALUE) {
			System.out.println("0");
		} else {			
			System.out.println(answer);
		}
		
	}

}