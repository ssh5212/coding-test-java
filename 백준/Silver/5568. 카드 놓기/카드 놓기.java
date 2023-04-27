import java.io.*;
import java.util.*;

public class Main {
	
	static String[] sel;
	static boolean[] v;
	static HashSet<String> answers = new HashSet<>();
	static String[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 첫 번째 줄
		int n = Integer.parseInt(st.nextToken()); // n = 카드 개수
		
		// 두 번째 줄
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken()); // k = 고르는 카드 개수
		
		arr = new String[n];
		sel = new String[k];
		v = new boolean[n];
		
		// 나머지 줄
		for (int i = 0; i < n; i++) { 
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken();
		}
		
		recursive(0);
		
		System.out.println(answers.size());
		
	}

	private static void recursive(int count) {
		// basis
		if (count == sel.length) {
			String ans = "";
			for (String s : sel) {
				ans+=s;
			}
			
			answers.add(ans);
			return;
		}
		
		// inductive
		for (int i = 0; i < arr.length; i++) {
			if(v[i] == true) continue;
			v[i] = true;
			sel[count] = arr[i];
			recursive(count + 1);
			v[i] = false;
			sel[count] = "";
			
		}
	}
}