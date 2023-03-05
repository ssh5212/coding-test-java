import java.io.*;
import java.util.*;

public class Solution {
	
	// 서로소
	static int parents[];
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			// 첫 번째 줄
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 마을 수
			int M = Integer.parseInt(st.nextToken()); // 관계 수

			parents = new int[N + 1];
			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				union(from, to);
				
			}
			
			answer = 0;
			for (int i = 1; i < parents.length; i++) {
				if(parents[i] == i) {
					answer++;
				}
			}
			System.out.println("#" + test_case + " " + answer);
			
		} // [E] test_case

	}

	private static void union(int from, int to) {
		int pf = find(from);
		int pt = find(to);
		
		parents[pf] = pt;
	}

	private static int find(int s) {
		if(parents[s] == s) {
			return s;
		}
		return parents[s] = find(parents[s]);
	}
}