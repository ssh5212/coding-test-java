import java.io.*;
import java.util.*;

public class Main {
	static int N; // 도시 개수
	static int[] population; // 각 도시의 사람 수
	static int[][] adj; // 연결 정보 저장
	static boolean[] v;
	static boolean[] sel;

	static int answer; // 정답

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 첫 번쨰 줄
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		adj = new int[N + 1][N + 1];
		v = new boolean[N + 1]; 
		sel = new boolean[N + 1]; 

		// 두 번쨰 줄
		st = new StringTokenizer(br.readLine());
		population = new int[N + 1];
		for (int i = 1; i < population.length; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(population));

		// 나머지 줄
		for (int x = 1; x < adj.length; x++) {
			st = new StringTokenizer(br.readLine());
			int connectSize = Integer.parseInt(st.nextToken());
			for (int _i = 0; _i < connectSize; _i++) {
				int y = Integer.parseInt(st.nextToken());
				adj[x][y] = 1;
				adj[y][x] = 1;
			}
		}
		
//		print(adj);
		
		powerSet(1);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
		

	} // [E] main

	private static void powerSet(int idx) {
		if(idx == sel.length) {
//			System.out.println(Arrays.toString(sel));
			ArrayList<Integer> areaA = new ArrayList<>();
			ArrayList<Integer> areaB = new ArrayList<>();
			
			for (int i = 1; i < sel.length; i++) {
				if(sel[i] == true) {
					areaA.add(i);
				} else {					
					areaB.add(i);
				}
			}
			
			if (areaA.size() == 0 || areaB.size() == 0) return;
			
			// 연결성 조사
			boolean[] v= new boolean[N + 1];
			dfs(areaA.get(0), areaA, v);
			dfs(areaB.get(0), areaB, v);
			
			boolean flag = true;
			for (int i = 1; i < v.length; i++) {
				if(v[i] == false) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				// 값이 true라면 모든 노드가 다 연결이 된 것
				int sumA = 0;
				int sumB = 0;
				for (int i = 0; i < areaA.size(); i++) {
					sumA += population[areaA.get(i)];
				}
				for (int i = 0; i < areaB.size(); i++) {
					sumB += population[areaB.get(i)];
				}
				
				answer = Math.min(answer, Math.abs(sumA - sumB));
			}
			
			return;
		}
		
		
		sel[idx] = true;
		powerSet(idx + 1);
		sel[idx] = false;
		powerSet(idx + 1);
	}

	private static void dfs(Integer idx, ArrayList<Integer> area, boolean[] v) {
		v[idx] = true;
		for (int i = 1; i < area.size(); i++) {
			if (!v[area.get(i)] && adj[idx][area.get(i)] == 1) {
				dfs(area.get(i), area, v);
			}
		}
	}

	private static void print(int[][] adj) {
		for (int i = 1; i < adj.length; i++) {
			for (int j = 1; j < adj.length; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}