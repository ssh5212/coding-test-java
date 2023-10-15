import java.io.*;
import java.util.*;

public class Main {

	static int X;
	static int Y;
	static int[][] map;
	static int answer;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		map = new int[X][Y];
		dp = new int[X][Y];

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		print(map);

		// 완탐
//		answer = 0;
//		dfs(0, 0);
//		System.out.println(answer);

		// 메모이제이션 사용
		System.out.println(dfs2(0, 0));
	}

	private static int dfs2(int x, int y) {
		if (x == X - 1 && y == Y - 1) {
			answer++;
			return 1;
		}

		int answer = 0;

		if (dp[x][y] != -1) { // 지나간 적이 있는 길이라면
			return dp[x][y];
		}
		dp[x][y] = 0; // 지나왔음을 표기
		for (int d = 0; d < dx.length; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < X & ny >= 0 && ny < Y && map[nx][ny] < map[x][y]) {
				answer += dfs2(nx, ny);
			}
		}

		dp[x][y] = answer;
		return dp[x][y];
	}

	private static void dfs(int x, int y) {
		if (x == X - 1 && y == Y - 1) {
			answer++;
			return;
		}

		for (int d = 0; d < dx.length; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < X & ny >= 0 && ny < Y && map[nx][ny] == -1) {
				dfs(nx, ny);
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