import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		int answerX = -1000;
		int answerY = -1000;
		
		for (int i = -999; i <= 999; i++) {
			for (int j = -999; j <= 999; j++) {
				if (a * i + b * j == c && d * i + e * j == f) {
					answerX = i;
					answerY = j;
					
					System.out.println(i + " " + j);
				}
			}
		}
	}

}