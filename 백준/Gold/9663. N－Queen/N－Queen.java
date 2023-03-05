import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int N;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		solve(0);
		System.out.println(count);

	}

	private static void solve(int idx) {
		// basis part
		// 행의 끝까지 가서 성공이라면
		if (idx == N) {
			count++;
			return;
		}

		// inductive part
		for (int i = 0; i < N; i++) {
			map[idx][i] = 1;
			if (check(idx, i)) {
				solve(idx + 1);
			}
			map[idx][i] = 0;
		}

	}

	// 1(Queue)인지 확인
	private static boolean check(int x, int y) {
		// 좌상
		for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
			if (map[i][j] == 1) {
				return false;
			}
		}

		// 상
		for (int i = x - 1; i >= 0; i--) {
			if (map[i][y] == 1) {
				return false;
			}
		}

		// 우상
		for (int i = x - 1, j = y + 1; i >= 0 && j < N; i--, j++) {
			if (map[i][j] == 1) {
				return false;
			}
		}

		return true;
	}
}
