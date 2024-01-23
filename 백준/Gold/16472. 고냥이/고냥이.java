import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		
		int[] alphabet = new int[26];
		
		int a = (int)'a'; // 97

		int lt = 0;
		int rt = 0;
		int typeCount = 0; // 현재 문자의 개수
		int answer = 0;
		
		// 끝 문자를 벗어날 때까지 반복
		while (rt < s.length()) {
			int now = (int)s.charAt(rt) - a;
			
			// 처음 만난 문자인 경우
			if (alphabet[now] == 0) {
				alphabet[now]++;
				typeCount++;
			} 
			// 기존에 만난 문자인 경우
			else {
				alphabet[now]++;
			}
			
			// 계산 후 현재 만난 문자열 종류가 최대 종류보다 많은 경우 반복
			while (typeCount > N) {
				int nowLt = (int)s.charAt(lt) - a;
				alphabet[nowLt]--;
				if (alphabet[nowLt] == 0) {
					typeCount--;
				}
				lt++;
			}
			
			answer = Math.max(answer, rt - lt + 1);
			rt++;
			
		}
		
		System.out.println(answer);

	}
}