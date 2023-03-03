import java.io.*;
import java.util.*;

public class Solution {

	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	static int[][] map;
	static int N, W, H;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 던져지는 횟수
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = Integer.MAX_VALUE;

			// 구슬 떨어뜨리기 : 중복 순열
			sel = new int[N];
			recursive(0);

			System.out.println("#" + test_case + " " + answer);

		} // [E] test_case
	}

//	static boolean[] v; 
	static int[] sel;
	static int[][] temp;
//	static Queue<Point> q;

	static class Point {
		int x;
		int y;
		int cost; // 터지는 범위

		public Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

	// 구슬 떨어뜨리기 : 중복 순열
	private static void recursive(int count) {
		// 떨어뜨릴 구슬 정해지면
		if (count == sel.length) {
//			System.out.println(Arrays.toString(sel));

			// 맵 복사하기
			temp = new int[H][W];
			for (int i = 0; i < map.length; i++) {
				System.arraycopy(map[i], 0, temp[i], 0, map[i].length);
			}
//			print(temp);

			// 구슬 떨어뜨리기, 터뜨릴 벽 찾기
//			q = new LinkedList<>();
			go();

			Counter();

			return;
		}

		// recursive part
		// 떨어뜨릴 구슬 정하기
		for (int i = 0; i < W; i++) {
			sel[count] = i;
			recursive(count + 1);
			sel[count] = 0;
		}
	}

	private static void Counter() {
		int nowAnswer = 0;
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if (temp[j][i] != 0) {
					nowAnswer += 1;
				}
			}
		}

		answer = Math.min(answer, nowAnswer);

	}

	// 벽돌 내리기 : 완탐 + 스택
	static Stack<Integer> stack = new Stack<>();

	private static void down() {
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if (temp[j][i] != 0) {
					stack.push(temp[j][i]);
					temp[j][i] = 0;
				}
			}
			int nowH = H - 1;
			while (!stack.isEmpty()) {
				temp[nowH][i] = stack.pop();
				nowH--;
			}
		}

	}

	// 구슬 떨어뜨리기
	private static void go() {
		// 던지는 횟수만큼 반복
		for (int i = 0; i < sel.length; i++) {
			int nowY = sel[i]; // 현재 던질 열
			// 행 마다 체크
			for (int j = 0; j < H; j++) {
				// 1이면 0으로 바꾸자
				if (temp[j][nowY] == 1) {
					temp[j][nowY] = 0;

					break;
				}
				if (temp[j][nowY] > 1) {
					// 벽 터뜨리기 : BFS Queue
					bfs(j, nowY, temp[j][nowY]);

					break;
				}
			}
			down();
		}


	}

	private static void bfs(int x, int y, int cost) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y, temp[x][y]));
		temp[x][y] = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int co = 1; co < p.cost; co++) { // 내 숫자만큼 범위
				for (int d = 0; d < dx.length; d++) { // 사방
					int cx = p.x + dx[d] * co;
					int cy = p.y + dy[d] * co;
					// 범위를 벗어나지 않았고
					if (cx >= 0 && cx < H && cy >= 0 && cy < W) {
						// 현재 값이 1이면
						if (temp[cx][cy] == 1) {
							temp[cx][cy] = 0;
						}
						// 현재 값이 1보다 크면
						if (temp[cx][cy] > 1) {
							q.offer(new Point(cx, cy, temp[cx][cy]));
							temp[cx][cy] = 0;
						}
					}
				}
			}
		}

	}

	private static void print(int[][] temp) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
	}

}