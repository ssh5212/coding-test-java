import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] arr = new int[31];
		for (int i = 0; i < 28; i++) {
			st = new StringTokenizer(br.readLine());
			
			int now = Integer.parseInt(st.nextToken());
			arr[now] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 0) {
				System.out.println(i);
			}
		}
	}

}