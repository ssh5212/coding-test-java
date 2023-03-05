import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] adj;
	static int answer;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 첫 번째 줄
		int N = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		v = new boolean[N + 1];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}

		// 두 번째 줄
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		// 나머지 줄
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adj[from].add(to);
			adj[to].add(from);
		}

		answer = 0;
		dfs(1);
		System.out.println(answer - 1); // 본인은 빼야 함
		
	}

	private static void dfs(int idx) {
		answer++;
		v[idx] = true;
		
		for (int i = 0; i < adj[idx].size(); i++) {
			int now = adj[idx].get(i);
			if (v[now] == false) {
				dfs(now);
			}
		}
	}
}