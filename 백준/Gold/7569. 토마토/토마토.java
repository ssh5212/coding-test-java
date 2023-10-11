import java.io.*;
import java.util.*;

public class Main {
	static int[][][] map;
	
	static int[] nr = {-1, 0, 1, 0, 0, 0};
	static int[] nc = {0, 1, 0, -1, 0, 0};
	static int[] nh = {0, 0, 0, 0, 1, -1};
	
	static class Point {
		int h;
		int r;
		int c;
		int level;
		char type;
		
		Point (int h, int r, int c, int level) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.level = level;
		}
	}
	
	static int answer = 0;
	static Queue<Point> q = new LinkedList<>();  
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); // 가로 칸 수
		int N = Integer.parseInt(st.nextToken()); // 세로 칸 수
		int H = Integer.parseInt(st.nextToken()); // 쌓아진 상자 수
		
		map = new int[H][N][M];
		int zeroCnt = 0;
		
		// 입력
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < M; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if (map[k][i][j] == 1) {
						zeroCnt++;
					}
				}
			}
		}

		
//		print();
		
		// Queue에 저장
		for (int k = 0; k < map.length; k++) {
			for (int i = 0; i < map[0].length; i++) {				
				for (int j = 0; j < map[0][0].length; j++) {
					if (map[k][i][j] == 1) {
						q.offer(new Point(k, i, j, 0));
					}
				}
			}
		}
		
		bfs();
		
		for (int k = 0; k < map.length; k++) {
			for (int i = 0; i < map[0].length; i++) {				
				for (int j = 0; j < map[0][0].length; j++) {
					if (map[k][i][j] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		System.out.println(answer);
		
	} // [E] Main

	
	static void bfs() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < nr.length; d++) {
				int dr = p.r + nr[d];
				int dc = p.c + nc[d];
				int dh = p.h + nh[d];
				
				if (dh >= 0 && dh < map.length && dr >= 0 && dr < map[0].length &&
						dc >= 0 && dc < map[0][0].length && map[dh][dr][dc] == 0) {
					q.offer(new Point(dh, dr, dc, p.level + 1));
					map[dh][dr][dc] = 1;
					answer = p.level + 1;
				}
			}
		}
	}
	
	static void print() {
		for (int k = 0; k < map.length; k++) {
			for (int i = 0; i < map[0].length; i++) {
				
				for (int j = 0; j < map[0][0].length; j++) {
					System.out.print(map[k][i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}