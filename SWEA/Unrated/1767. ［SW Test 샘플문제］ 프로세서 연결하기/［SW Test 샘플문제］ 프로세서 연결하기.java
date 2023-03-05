import java.io.*;
import java.util.*;

public class Solution {

	static int[][] map;
	static boolean[][] v;
	static int N;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Point> list;
	static int answer;
	static int processer;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {

			// 첫 번째 줄
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			v = new boolean[N][N];
			list = new ArrayList<>();
			processer = 0;
			answer = Integer.MAX_VALUE;

			// 나머지 줄
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] == 1) {
						// 벽에 붙지 않은 프로세스만 추가
						if (!(i == 0 || i == N - 1 || j == 0 || j == N - 1)) {
							list.add(new Point(i, j));
						}
						v[i][j] = true;
					}
				}
			}
//			print(map);

			dfs(0, 0, 0);
			System.out.println("#" + test_case + " " + answer);

		} // [E] test_case

	} // [E] main

	// 프로세서 방문 개수, 현재 연결된 프로세서 수, 줄 길이
	private static void dfs(int vCount, int pConnect, int lCount) {
		if (vCount == list.size()) {
			if (processer < pConnect) {
				processer = pConnect;
				answer = lCount;
			}
			if (processer == pConnect) {
				answer = Math.min(answer, lCount);
			}
			return;
		}

		int x = list.get(vCount).x;
		int y = list.get(vCount).y;
		for (int d = 0; d < dx.length; d++) {
			for (int i = 1; i <= N; i++) {
				int cx = x + dx[d] * i;
				int cy = y + dy[d] * i;

				// 직선상에 true가 있다면
				if (cx >= 0 && cx < N && cy >= 0 && cy < N && v[cx][cy] == true) {
					dfs(vCount + 1, pConnect, lCount);
					break;
				}
				// 가장 자리까지 도착 했다면
				if (cx == -1 || cx == N || cy == -1 || cy == N) {
					for (int s = 1; s < i; s++) {
						v[x + dx[d] * s][y + dy[d] * s] = true;
					}
					int now = i - 1;
					dfs(vCount + 1, pConnect + 1, lCount + now);
					for (int s = 1; s < i; s++) {
						v[x + dx[d] * s][y + dy[d] * s] = false;
					}
					break;
				}

			}
		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}