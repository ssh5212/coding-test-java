import java.io.*;
import java.util.*;

public class Main {

	static int[] sel = new int[2];
	static LinkedList<Integer> list = new LinkedList<>();
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		for (int tc = 0; tc < N; tc++) {
			answer = 0;
			list.clear();
			st = new StringTokenizer(br.readLine());	
			while(st.hasMoreElements()) {
				list.add( Integer.parseInt(st.nextToken()) );
			}
			
			recursive(0, 0);
			System.out.println(answer);
		}
		
		
	}
	
	public static int gcd (int a, int b) {
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		if (a % b == 0) {
			return b;	
		}
		if (a - b <= answer) return 1;
		return gcd(b, a % b);
	}
	
	public static void recursive(int count, int index) {
		if (count == sel.length) {
			int nowAnswer = gcd(sel[0], sel[1]);
			
			if (answer < nowAnswer) {
				answer = nowAnswer;
			}

			return;
		}
		
		for (int i = index; i <list.size(); i++) {
			sel[count] = list.get(i);
			recursive(count + 1, i + 1);
			sel[count] = 0;
		}
		
	}

}