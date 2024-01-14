import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[w+2];
		int[] suffix = new int[w+2];
		int[] prefix = new int[w+2];
		
		st = new StringTokenizer(br.readLine());		
		for (int i = 1; i <= w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= w; i++) {
			prefix[i] = Math.max(prefix[i - 1], arr[i]);
		}
		
		for (int i = w; i > 0; i-- ) {
			suffix[i] = Math.max(suffix[i + 1], arr[i]);
		}
		
		int answer = 0;
		for (int i = 1; i <= w; i++) {
			answer += Math.min(prefix[i], suffix[i]);
			answer -= arr[i];
		}
		
		System.out.println(answer);
		
	}

}