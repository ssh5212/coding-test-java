import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		
		int cnt = 0;
 
		for (int i = 666; i <= 10000666; i++) {
			int now = i;
			int nowLength = Integer.toString(now).length();
			
			int count6 = 0;
			for (int j = 0; j < nowLength; j++) {
				int remainder = now % 10;
				now = now / 10;
				
				if (remainder == 6) {
					count6 += 1;
					
					if (count6 == 3) {
						cnt += 1;
						if (cnt == N) {
							System.out.println(i);
							return;
						}
						break;
					}
				} else {
					count6 = 0;
				}
			}
			
		}
	}

}