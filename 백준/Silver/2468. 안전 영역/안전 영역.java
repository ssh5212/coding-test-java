import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static int[][] copyMap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 첫 번째 줄
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		copyMap = new int[N][N];
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int j = 0;
			while(st.hasMoreElements()) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (max < map[i][j]) {
					max = map[i][j];
				}
				j++;
			}
			
		}
		// print();
		
		int answer = 1;
		
		// k : 수위
		for (int k = 1; k < max; k++) {
			int k_answer = 0;
			// 수위와 같은 값은 0으로 바꿔버림
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map[i][j] == k) {
						map[i][j] = 0;
					}
					
					copyMap[i][j] = map[i][j];
				}
			}
			
			// bfs
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (copyMap[i][j] != 0) {
						bfs(i, j);
						k_answer++;
					}
				}
			}
			answer = Math.max(answer, k_answer);
		}
		System.out.println(answer);
	}
	
	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}	
	}
	
	static int[] nr = {-1, 0, 1, 0};
	static int[] nc = {0, 1, 0, -1};
	
	static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i, j));
		copyMap[i][j] = 0;
		
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < nr.length; d++) {
				int dr = p.r + nr[d];
				int dc = p.c + nc[d];
				
				if (dr >= 0 && dr < map.length && dc >= 0 && dc < map[0].length && copyMap[dr][dc] != 0) {
					copyMap[dr][dc] = 0;
					q.offer(new Point(dr, dc));
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