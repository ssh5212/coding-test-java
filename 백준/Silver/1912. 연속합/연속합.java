import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] a = new int[N];
		int[] m = new int[N]; // 시작지점부터 i 위치까지 더한 최대값을 저장
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		m[0] = a[0];
		int answer = m[0];
		for (int i = 1; i < N; i++) {
			m[i] = Math.max(m[i - 1] + a[i], a[i]);
			answer = Math.max(answer, m[i]);
		}
		
		System.out.println(answer);
		
	}

}