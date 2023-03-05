import java.io.*;
import java.util.*;

public class Main {
	
	static int map[][];
	static int answer;
	static boolean[][] v;
	static int N;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	// 물고기의 경우 level이 거리임
	static class Fish implements Comparable<Fish> {
		int x;
		int y;
		int level;
		int exp;

		public Fish(int x, int y, int level, int exp) {
			this.x = x;
			this.y = y;
			this.level = level;
			this.exp = exp;
		}

		@Override
		public int compareTo(Fish o) {
			return Integer.compare(this.level, o.level);
		}
		
		
	}
	
	static PriorityQueue<Fish> food;

	static Fish shark;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 첫 번째 줄
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		
		// 나머지 줄
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 9) {
					shark = new Fish(i, j, 2, 0);
					map[i][j] = 0;
				}
				
			}
		}

		answer = 0;
		while(true) {
			v = new boolean[N][N];
			food = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > shark.level) {
						
						v[i][j] = true;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0 && map[i][j] < shark.level) {
						bfs(i, j);
					}
				}
			}
			
			// 먹을 수 있는 물고기가 아무것도 없으면
			if (food.isEmpty()) {
				break;
			}
			
			Fish p = food.poll();
			shark.x = p.x;
			shark.y = p.y;
			shark.exp++;
			map[p.x][p.y] = 0;
			
			if(shark.exp == shark.level) {
				shark.exp = 0;
				shark.level++;
			}
			answer += p.level;
		}
		
		System.out.println(answer);
		
		
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
	
	// 먹이 위치 구하기
	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(i, j, 0));
		
		boolean[][] temp = new boolean[N][N];
		for (int t = 0; t < map.length; t++) {
			System.arraycopy(v[t], 0, temp[t], 0, map[0].length);			
		}
		temp[i][j] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			int x = p.x;
			int y = p.y;
			
			for (int d = 0; d < dx.length; d++) {
				int cx = x + dx[d];
				int cy = y + dy[d];
				
				if (cx >= 0 && cx < N && cy >= 0 && cy < N && temp[cx][cy] == false) {
					if (cx == shark.x && cy == shark.y) {
						food.offer(new Fish(i, j, p.level + 1, 0));
						return;
					}
					temp[cx][cy] = true;
					q.offer(new Point(cx, cy, p.level + 1));
					
				}
			}
			
		}
		
	}
}