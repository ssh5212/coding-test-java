import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[][] b = new int[N + 1][R + 1];

			// 파스칼의 삼각형 공식 이용
			// nCr == nC(n-r)
			for (int i = 0; i <= N; i++) {
				// 뽑으려는 R보다 N이 작은 경우 N개만큼 뽑겠다
				for (int j = 0, end = Math.min(i, R); j <= end; j++) {
					if (j == 0 || i == j) { // 파스칼 삼각형의 끝 부분
						b[i][j] = 1; // 1로 채움
					} else { // 가운데 부분은 두 가지 수의 영향을 받음
						b[i][j] = b[i - 1][j - 1] + b[i - 1][j];
					}
				}
			}
			System.out.println(b[N][R]);

		}

	}
}