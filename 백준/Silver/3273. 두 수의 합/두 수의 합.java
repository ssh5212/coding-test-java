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
		int X = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		int lt = 0;
		int rt = arr.length - 1;
		
		while (lt < rt) {
			if (arr[lt] + arr[rt] == X) {
				answer++;
				lt++;
				rt--;
			} else if (arr[lt] + arr[rt] > X) {
				rt--;
			} else {
				lt++;
			}
		}
		
		System.out.println(answer);
	}

}