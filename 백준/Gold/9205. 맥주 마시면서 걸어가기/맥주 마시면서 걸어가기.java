import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < T; t++) {
			// 첫 번째 줄
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 편의점 개수
			
			int N = n + 2; // 한 줄의 길이
			String answer = "";
			
			
			int[][] map = new int[n+2][n+2];
			int INF = 9999999;
			for (int i = 0; i < map.length; i++) {
				Arrays.fill(map[i], INF);
			}
			
			int[] inputX = new int[n+2];
			int[] inputY = new int[n+2];
			
			
			for (int i = 0; i < N; i++) {
				// 나머지 줄
				st = new StringTokenizer(br.readLine());
				inputX[i] = Integer.parseInt(st.nextToken());
				inputY[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) {
						map[i][j] = 0;
					} else {
						map[i][j] = Math.abs(inputX[i] - inputX[j]) + Math.abs(inputY[i] - inputY[j]);
						if(map[i][j] > 1000) {
							map[i][j] = INF;
						}
					}
				}
			}
//			print(map);
//			System.out.println();
			

			// 경출도
			for (int k = 0; k < N; k++) { // 경
				for (int i = 0; i < N; i++) { // 출
					if (i == k) continue; // 출발지와 경유지가 같다면 continue
					for (int j = 0; j < N; j++) { // 도
						if (i == j || k == j) continue;
						if (map[i][k] + map[k][j] <= 2000) {
							map[i][j] = 1000;
						}
					}
				}
			}
			
//			print(map);
			if (map[0][N-1] <= 1000) {
				System.out.println("happy");				
			} else {
				System.out.println("sad");								
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