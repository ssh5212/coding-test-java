import java.io.*;
import java.util.*;

public class Main {

	static int answer;
	static int[][] map;
	static boolean[][] v;
	static int N;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		answer = Integer.MAX_VALUE;
		map = new int[N][N];
		int nowIsland = 2;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 번호 지정
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					bfs(i, j, nowIsland);
					nowIsland++;
				}
			}
		}

		// 섬 거리 계산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 0) {
					v = new boolean[N][N];
					bfs2(i, j, map[i][j]);
				}
			}
		}

		System.out.println(answer);

	} // [E] main

	// 바다 거리 계산
	private static void bfs2(int i, int j, int nowIsland) {
		Queue<Point> q = new LinkedList<>();

		q.offer(new Point(i, j, 0));
		v[i][j] = true;

		// 섬과 인접한 바다 찾기
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			if (p.level >= answer) {
				continue;
			}

			for (int d = 0; d < dx.length; d++) {
				int cx = p.x + dx[d];
				int cy = p.y + dy[d];

				// 맵 내에서
				if (cx >= 0 && cx < N && cy >= 0 && cy < N) {
					// 인접한 바다라면
					if (map[cx][cy] == 0 && v[cx][cy] == false) {
						v[cx][cy] = true;
						q.offer(new Point(cx, cy, p.level + 1));
					}

					// 방문한적 없는 땅이라면
					if (map[cx][cy] != nowIsland && v[cx][cy] == false) {
						answer = Math.min(answer, p.level);
					}
				}

			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=====");
	}

	static class Point {
		int x;
		int y;
		int level;

		public Point(int x, int y, int level) {
			this.x = x;
			this.y = y;
			this.level = level;
		}
	}


	// 섬 분류
	private static void bfs(int x, int y, int nowIsland) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y, nowIsland));
		map[x][y] = nowIsland;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < dx.length; d++) {
				int cx = p.x + dx[d];
				int cy = p.y + dy[d];

				// 범위를 벗어나지 않고 1이라면
				if (cx >= 0 && cx < N && cy >= 0 && cy < N && map[cx][cy] == 1) {
					map[cx][cy] = nowIsland;
					q.offer(new Point(cx, cy, nowIsland));
				}

			}
		}
	}

}
