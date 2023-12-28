import java.io.*;
import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
		int answer = 0;
		
		int before = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int now = before + arr[i];
			if (now > 100) {
				if (Math.abs(100 - before) >= Math.abs(100 - now)) {
					answer = now;
				} else {
					answer = before;
				}
				break;
				
			} else {
				before = before + arr[i];
			}
		}
		
		// 100을 넘는 케이스가 없는 경우
		if (answer == 0) {
			answer = before;
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] arr = new int[10]; 
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = solution(arr);
		
		System.out.println(answer);
		
	}

}