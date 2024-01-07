import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		for (long i = 1; i <= N; i++) {
			if (i * i <= N) {
				answer++;
			} else {
				break;
			}
		}
		System.out.println(answer);
	}

}