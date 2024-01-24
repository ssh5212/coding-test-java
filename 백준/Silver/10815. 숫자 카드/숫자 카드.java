import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 카드 개수

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[] tc = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			tc[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] answer = new int[M];
		
		for (int i = 0; i < tc.length; i++) { // 비교할 숫자 개수만큼 반복
			int str = 0;
			int end = N - 1;
			while (str <= end) {
				int mid = (end + str) / 2;
				
				if (arr[mid] > tc[i]) { // mid를 포함한 오른쪽은 절대 아님
					end = mid - 1;
				} else if (arr[mid] < tc[i]) { // mid를 포함한 왼쪽은 절대 아님
					str = mid + 1;
				} else if (tc[i] == arr[mid]) {
					answer[i] = 1;
					break;
				}
			}
		}
		
		for (int x: answer) {
			System.out.print(x + " ");
		}
		
		
		
	}

}