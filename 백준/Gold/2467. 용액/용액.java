import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int lt = 0;
		int rt = N - 1;
		
		int nearNum = Integer.MAX_VALUE;
		int[] answer = new int[2];
		
		while (lt < rt) {
			int now = arr[lt] + arr[rt];
			
			// 기존보다 0에 가까우면 정답 갱신
			if (nearNum > Math.abs(now)) {
				answer[0] = arr[lt];
				answer[1] = arr[rt];
				nearNum = Math.abs(now);
			}
			
			// 결과가 양수인 경우 rt를 왼쪽으로 이동
			if (now >= 0) {
				rt--;
			}

			// 결과가 음수인 경우 lt를 오른쪽으로 이동
			else if (now < 0) {
				lt++;
			} 

			
		}
		
		System.out.println(answer[0] + " " + answer[1]);
	}

}