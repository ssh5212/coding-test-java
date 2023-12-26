import java.io.*;
import java.util.*;

// 자연수는 100보다 작거나 같음
// 완탐 시 최악의 경우 100 * 100 * 100 -> 100만
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		st = new StringTokenizer(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();
				
		while(st.hasMoreElements()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		L: for (int i = 1; i <= 100000000; i++) {
			int tmp = 0;
			for (int j = 0; j < 5; j++) {
				if (i % list.get(j) == 0) {
					tmp++;
				}
				if (tmp >= 3) {
					System.out.println(i);
					break L;
				}
			}
		}	
	}

}