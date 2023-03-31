import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int[][] d;
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 1, 0 };
	static int answer;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 집의 크기 == 행/열의 길이
		map = new int[N][N];
		d = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		print(map);
		
		// dfs 완탐
//		answer = 0;
//		dfs(0, 1, 0); // 0행 1열에서 시작함
//		System.out.println(answer);

		// dfs 메모이제이션
		System.out.println(dfs2(0, 1, 0)); // 0행 1열에서 시작함

	}

	private static int dfs2(int x, int y, int rot) {
		if (x == N - 1 && y == N - 1) {
			return 1;
		}

		int answer = 0;
		for (int d = 0; d < dx.length; d++) {
			// 기존 각도에 따라서 선택지가 다름
			if (rot == 0 && d == 2)
				continue;
			if (rot == 2 && d == 0)
				continue;
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
				if (d == 1) {
					if (map[x][y + 1] == 0 && map[x + 1][y] == 0) {
						answer += dfs2(nx, ny, d);
					}
				} else {
					answer += dfs2(nx, ny, d);
				}
			}
		}

		d[x][y] = answer;
		return d[x][y];

	}

	private static void dfs(int x, int y, int rot) {
		if (x == N - 1 && y == N - 1) {
			answer++;
			return;
		}

		for (int d = 0; d < dx.length; d++) {
			// 기존 각도에 따라서 선택지가 다름
			if (rot == 0 && d == 2)
				continue;
			if (rot == 2 && d == 0)
				continue;
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
				if (d == 1) {
					if (map[x][y + 1] == 0 && map[x + 1][y] == 0) {
						dfs(nx, ny, d);
					}
				} else {
					dfs(nx, ny, d);
				}
			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}