import java.io.*;
import java.util.*;

public class Main {
	
	public static boolean isPrime(int num) {
		if (num < 2) return false;
		if (num == 2) return true;
		
		for (int i = 2; i < num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if (isPrime(Integer.parseInt(st.nextToken())) == true) {
				answer++;
			}
		}
		System.out.println(answer);

		
	}

}