import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		int third = Integer.parseInt(st.nextToken());
		int total = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		L: for (int i = 0; i <= 50; i++) {
			for (int j = 0; j <= 50; j++) {
				for (int k = 0; k <= 50; k++) {
					int now = first * i + second * j + third * k;
					if (now == total) {
						answer = 1;
						break L;
					}
					
					if (now > total) {
						break;
					}
				}
			}
		}
		System.out.println(answer);
	}

}