import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String[] arr;
	static String[] sel;
	static boolean[] v;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		// 첫 번째 줄
		int L = Integer.parseInt(st.nextToken()); // 암호의 길이
		int C = Integer.parseInt(st.nextToken()); // 암호에 들어갈 문자의 개수
		
		v = new boolean[C];
		sel = new String[L];
		arr = new String[C];
		// 두 번째 줄
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = st.nextToken();
		}
		Arrays.sort(arr);
		
		recursive(0, 0);
		
		System.out.println(sb);
	}
	
	private static void recursive(int cnt, int start) {
		// basis
		if (cnt == sel.length) {
			String password = "";
			int ja = 0;
			int mo = 0;
			for (int i = 0; i < sel.length; i++) {
				if (sel[i].equals("a") || sel[i].equals("e") || sel[i].equals("i") || sel[i].equals("o") || sel[i].equals("u") ) {
					mo++;
				} else {
					ja++;
				}
			}
			
			if (ja >= 2 && mo >= 1) {
				for (int i = 0; i < sel.length; i++) {
					sb.append(sel[i]);
				}
				sb.append("\n");
			}
			
//			System.out.println(Arrays.toString(sel));
			return;
		}
		
		// inductive
		for (int i = start; i < arr.length; i++) {
//			if (v[i] == true) continue;
//			v[i] = true;
			sel[cnt] = arr[i];
			recursive(cnt + 1, i + 1);			
			sel[cnt] = "";
//			v[i] = false;
		}
		
	}
}