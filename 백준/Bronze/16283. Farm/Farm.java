import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int a1 = -1;
		int a2 = -1;

		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= 1000; j++) {
				if (i + j  == n) {
					if (a * i + b * j == w) {
						if (a1 != -1) {
							System.out.println(-1);
							return;
						}
						a1 = i;
						a2 = j;
					}
				}
			}
		}
		if (a1 == -1) {
			System.out.println(-1);
		} else {
			System.out.print(a1 + " ");
			System.out.print(a2);
		}
	}

}