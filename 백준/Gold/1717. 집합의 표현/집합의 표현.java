import java.io.*;
import java.util.*;

public class Main {

	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		ArrayList<ArrayList<Integer>> node = new ArrayList<>();

		// 첫 번째 줄
		int n = Integer.parseInt(st.nextToken()); // 최대 값
		int m = Integer.parseInt(st.nextToken()); // 연산 횟수

		// 부모 값 저장
		parents = new int[n + 1];

		// 초기값 지정
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		// 나머지 줄
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int action = Integer.parseInt(st.nextToken()); // 0 = 합치기, 1 = 합쳐졌는지 확인
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (action == 0) {
				union(a, b);
			} else {
				int pa = find(a);
				int pb = find(b);

				// 부모가 같으면
				if (pa == pb) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}

		}

		System.out.println(sb);

	}

	// 합집합
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		// 왼쪽 집합을 오른쪽에 합침 
		parents[pa] = pb;

	}

	// 부모 찾기
	private static int find(int a) {
		if (parents[a] == a) {
			return a;
		} else {
			return parents[a] = find(parents[a]);
		}
	}

}