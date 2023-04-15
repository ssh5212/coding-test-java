import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int before = 0;
		char upanddown = 'z';
		String answer = "mixed";
		
		for (int i = 0; i < 8; i++) {
			if (i == 0) {
				before = Integer.parseInt(st.nextToken());
				if (before == 1) {
					upanddown = 'u';
					answer = "ascending";
					continue;
				} else if (before == 8) {
					upanddown = 'd';
					answer = "descending";
					continue;
				} else {
					break;
				}
				
			}
			
			int now = Integer.parseInt(st.nextToken());
			
			if (upanddown == 'u' && now -1 == before) {
				before = now;
				continue;
			} else if (upanddown == 'd' && now +1 == before) {
				before = now;
				continue;
			} else {
				answer = "mixed";
				break;
			}
			
			
		}
		
		System.out.println(answer);
		
		
	}
}