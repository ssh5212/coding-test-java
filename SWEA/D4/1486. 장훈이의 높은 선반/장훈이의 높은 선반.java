import java.io.*;
import java.util.*;

public class Solution {

	static int[] employee;
	static int N, B, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			// 첫 번째 줄
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 직원 수
			B = Integer.parseInt(st.nextToken()); // 구하고자 하는 탑의 높이

			answer = Integer.MAX_VALUE;
			employee = new int[N];

			// 두 번째 줄
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				employee[i] = Integer.parseInt(st.nextToken());
			}

			sel = new boolean[N]; // 선택 배열
			// 부분 집합
			recursive(0);

			System.out.println("#" + test_case + " " + answer);

		} // [E] test_case
	}

	static boolean[] sel;

	private static void recursive(int idx) {
		// basis
		if (idx == N) {

			int nowAnswer = 0;
			for (int i = 0; i < sel.length; i++) {
				if (sel[i] == true) {
					nowAnswer += employee[i];
				}
			}

			if (nowAnswer >= B) {
				answer = Math.min(answer, nowAnswer - B);
			}

			return;
		}

		// inductive
		sel[idx] = true;
		recursive(idx + 1);
		sel[idx] = false;
		recursive(idx + 1);

	}
}