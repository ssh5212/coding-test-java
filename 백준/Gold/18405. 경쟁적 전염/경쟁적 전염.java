import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int S;
	static int X;
	static int Y;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// print();
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) - 1;
		Y = Integer.parseInt(st.nextToken()) - 1;
		
		bfs();
		
		// pq가 모두 호출되기 전에 S초 만큼 지나서 끝난 상태
		if (answer != 0) {
			System.out.println(answer);
			return;
		}
		
		// S초보다 빨리 pq가 끝난 상태
		System.out.println(map[X][Y]);
		
	}
	
	static class Point implements Comparable<Point> {
		int r;
		int c;
		int virus;
		int level;
		
		Point (int r, int c, int virus, int level) {
			this.r = r;
			this.c = c;
			this.virus = virus;
			this.level = level;
		}

		@Override
		public int compareTo(Point other) {
			int compareLevel = Integer.compare(this.level, other.level);
			
			if (compareLevel == 0) {				
				return Integer.compare(this.virus, other.virus); // level 기준 오름차순
			}
			return compareLevel;
		}
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] != 0) {
					pq.offer(new Point(i, j, map[i][j], 0));
				}
			}
		}
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			if (p.level == S) {
				answer = map[X][Y];
				return;
			}
			
			for (int d = 0; d < dr.length; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length 
						&& map[nr][nc] == 0) {
					map[nr][nc] = p.virus;
					pq.offer(new Point(nr, nc, p.virus, p.level + 1));
				}
			}
			
		}
	}

	static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}