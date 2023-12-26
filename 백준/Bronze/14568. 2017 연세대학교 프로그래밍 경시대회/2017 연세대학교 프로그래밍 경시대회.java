import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		for (int i = 1; i < 99; i++) { // 남규
			for (int j = 1; j < 99; j++) { // 영훈
				for (int k = 1; k < 99; k++) { // 택희
					// 조건 1
					if (i + j + k != N) {
						continue;
					}
					// 조건 2
					if (i < j + 2) {
						continue;
					} 
					// 조건 3
					if (k % 2 != 0) {
						continue;
					}
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

}