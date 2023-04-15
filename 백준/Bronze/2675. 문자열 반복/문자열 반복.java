import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int time = Integer.parseInt(st.nextToken());
			
			String s = st.nextToken();
			for (int j = 0; j < s.length(); j++) {
				for (int k = 0; k < time; k++) {
					sb.append(s.charAt(j));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}