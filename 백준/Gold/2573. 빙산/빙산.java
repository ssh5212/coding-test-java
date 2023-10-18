import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static boolean[][] island;
	static boolean[][] v;
	static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 첫 번째 줄
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		island = new boolean[N][M];
		v = new boolean[N][M];
			
		// 두 번째 줄
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		for(int now = 0; ; now++) {
			
			// 두 덩어리로 쪼개졌는지 확인
			int islandCheck = 0;
			island = new boolean[N][M];
			v = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] < 0) {
						map[i][j] = 0;
					}
					if(map[i][j] > 0 && island[i][j] == false) {
						bfs(i, j);
						islandCheck += 1;
					}
				}
			}
//			print();
			
			if (islandCheck > 1) {

				answer = now;
				break;
			} else if (islandCheck == 0) {
				answer = 0;
				break;
			}
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] > 0 && v[i][j] == false) {
						bfs2(i, j);
					}
				}
			}
		}
		
		System.out.println(answer);
		
	}
	
	static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(island[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static int[] nr = {-1, 0, 1, 0};
	static int[] nc = {0, 1, 0, -1};
	
	static class Point {
		int r;
		int c;
		
		Point (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i, j));
		island[i][j] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < nr.length; d++) {
				int dr = p.r + nr[d];
				int dc = p.c + nc[d];
				
				if (dr >= 0 && dr < map.length && dc >= 0 && dc < map[0].length 
						&& island[dr][dc] == false && map[dr][dc] > 0) {
					island[dr][dc] = true;
					q.offer(new Point(dr, dc));
				}
			}
		}
	}
	
	static void bfs2(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i, j));
		v[i][j] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < nr.length; d++) {
				int dr = p.r + nr[d];
				int dc = p.c + nc[d];
				
				if (dr >= 0 && dr < map.length && dc >= 0 && dc < map[0].length) {
					// 인접한 곳이 빙산이 아니라면
					if (island[dr][dc] == false) {
						map[p.r][p.c] -= 1;
					} else if (v[dr][dc] == false) {						
						q.offer(new Point(dr, dc));
						v[dr][dc] = true;
					}
				}
			}
		}
	}

}