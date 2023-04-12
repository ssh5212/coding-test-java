import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int[][] mapCopy;
	static Queue<Point> q;
	static Queue<Point> qCopy;
	static int answer;

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 첫 번째 줄
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		q = new LinkedList<>();
		qCopy = new LinkedList<>();
		answer = 0;

		// 나머지 줄
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					q.offer(new Point(i, j));
				}
			}
		}

//		print(map);

		dfs(0);
		System.out.println(answer);

	}

	private static void dfs(int cnt) {
		// basis
		// 벽이 3개라면
		if (cnt == 3) {
			mapCopy = new int[map.length][map[0].length];
			copyMap(map, mapCopy);
			copyQ(q, qCopy);

			bfs();

			return;
		}

		// inductive
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 0) {
//					v[i][j][cnt] = true;
					map[i][j] = 1;
					dfs(cnt + 1);
					map[i][j] = 0;
//					v[i][j][cnt] = false;
				}
			}
		}
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static void bfs() {
		while (!qCopy.isEmpty()) {
			Point p = qCopy.poll();

			for (int d = 0; d < dx.length; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && mapCopy[nx][ny] == 0) {
					mapCopy[nx][ny] = 2;
					qCopy.offer(new Point(nx, ny));
				}
			}
		}

		int nowAnswer = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (mapCopy[i][j] == 0) {
					nowAnswer += 1;
				}
			}
		}
		if (answer < nowAnswer) {
			answer = nowAnswer;
//			print(mapCopy);
//			System.out.println("===================");
		}
	}

	private static void copyQ(Queue<Point> q, Queue<Point> qCopy) {
		for (int i = 0; i < q.size(); i++) {
			Point p = q.poll();
			q.offer(p);
			qCopy.offer(p);
		}

	}

	private static void copyMap(int[][] map, int[][] mapCopy) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				mapCopy[i][j] = map[i][j];
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

	}
}