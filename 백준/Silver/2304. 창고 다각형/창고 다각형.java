import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[1002];
		
		int maxLength = 0;
		int maxLoc = 0;
		int lastLoc = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int loc = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			arr[loc] = length;
			if (maxLength <= length) {
				maxLength = length;
				maxLoc = loc;
			}
			if (lastLoc < loc) {
				lastLoc = loc;
			}
			
		}
		
		int answer = 0;
		
		for (int i = 1; i < maxLoc; i++) {
			if (arr[i-1] >= arr[i]) {
				arr[i] = arr[i-1];
			}
			answer += arr[i];
		}
		
		answer += arr[maxLoc];
		
		for (int i = lastLoc; i > maxLoc; i--) {
			if (arr[i] < arr[i+1]) {
				arr[i] = arr[i + 1];
			}
			answer += arr[i];
		}
		System.out.println(answer);
	}

}