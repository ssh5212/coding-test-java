import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] a = new int[N + 1][M + 1];
		int[][] s = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());			
			for (int j = 1; j <= M; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= N; i++) {			
			for (int j = 1; j <= M; j++) {
				s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + a[i][j];
			}
		}
		
		int answer = Integer.MIN_VALUE;
		for (int x1 = 1; x1 <= N; x1++) {
			for (int y1 = 1; y1 <= M; y1++) {
				for (int x2 = x1; x2 <= N; x2++) {
					for (int y2 = y1; y2 <= N; y2++) {
						int now = s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1];
						
						answer = Math.max(answer, now);
					}
				}
			}
		}
		
		System.out.println(answer);
		
		
	}

}