import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int dasom = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); 
		for (int i = 0; i < N - 1; i++) {			
			st = new StringTokenizer(br.readLine());
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		int cnt = 0;
		while (!pq.isEmpty()) {
			if (dasom > pq.peek()) break;
			int nowPq = pq.poll();
			pq.offer(nowPq - 1);
			dasom += 1;
			cnt += 1;
		}

		System.out.println(cnt);
	}

}