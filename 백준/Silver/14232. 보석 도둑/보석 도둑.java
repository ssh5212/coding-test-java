import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long K = Long.parseLong(st.nextToken());
		
		LinkedList<Long> list = new LinkedList<>();
		
		int count = 0;
		for (long i = 2; i * i <= K; i++) {
			while (K % i == 0) {
				list.add(i);
				K /= i;
				count++;
			}
		}
		if (K != 1) {
			list.add(K);
			count++;
		}
		
		System.out.println(count);
		for (long x: list) {
			System.out.print(x + " ");
		}
		
	}

}