import java.io.*;
import java.util.*;

public class Main {
	static int answer;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static int N, M;
	static int[][][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 첫 번째 줄
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		map = new int[N][M];
		v = new int[N][M][2];

		// 나머지 줄
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		answer = Integer.MAX_VALUE;
		bfs();
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	static class Point {
		int x;
		int y;
		int tool;

		public Point(int x, int y, int tool) {
			this.x = x;
			this.y = y;
			this.tool = tool;
		}
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();

		q.offer(new Point(0, 0, 1));
		v[0][0][1] = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();

			int x = p.x;
			int y = p.y;

			if (x == N - 1 && y == M - 1) {
				answer = Math.min(answer, v[x][y][p.tool]);
				continue;
			}

			for (int d = 0; d < dx.length; d++) {
				int cx = p.x + dx[d];
				int cy = p.y + dy[d];

				// 한 번도 뚫은 적이 없다면
				if (p.tool == 1) {
					if (cx >= 0 && cx < N && cy >= 0 && cy < M) {
						// 갈 수 있는 길 & 한번도 가지 않은 길이라면
						if (map[cx][cy] == 0 && v[cx][cy][1] == 0) {
							q.offer(new Point(cx, cy, 1));
							v[cx][cy][1] = v[x][y][1] + 1;
						}

						if (map[cx][cy] == 1) {
							q.offer(new Point(cx, cy, 0));
							v[cx][cy][0] = v[x][y][1] + 1;
						}
					}
				}

				// 한 번 뚫은 적이 있으면
				else if (p.tool == 0) {
					if (cx >= 0 && cx < N && cy >= 0 && cy < M) {
						// 갈 수 있는 길이면
						if (map[cx][cy] == 0 && v[cx][cy][0] == 0) {
							q.offer(new Point(cx, cy, 0));
							v[cx][cy][0] = v[x][y][0] + 1;
						}
					}
				}

			}

		}

	}
}