import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		for (int i = 1; i <= 500; i++) {
			for (int j = 1; j <= 500; j++) {
				if (i * i == j * j + N) {
					answer++;
				}
			}
		}
		System.out.println(answer);

	}

}