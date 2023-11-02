import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		int answer = 0;
		
		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			answer = 0;
			
			int start = 0;
			int end = arr.length -1;
			
			
			while(start <= end) {
				int center = (start + end)/2;
				if (arr[center] > now) {
					end = center - 1;
				}
				if (arr[center] < now) {
					start = center + 1;
				}
				if (arr[center] == now) {
					answer = 1;
					break;
				}
			}
			System.out.println(answer);
		}
	}

}