import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int cnt = 0;

		while (st.hasMoreElements()) {
			int N = Integer.parseInt(st.nextToken());
			cnt += N * N;
		}

		System.out.println(cnt % 10);
	}
}