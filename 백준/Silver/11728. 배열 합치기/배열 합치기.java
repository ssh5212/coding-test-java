import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] a1 = new int[N];
		for (int i = 0; i < N; i++) {
			a1[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a1);
		
		st = new StringTokenizer(br.readLine());
		int[] a2 = new int[M];
		for (int i = 0; i < M; i++) {
			a2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a2);
		
		
		int[] answer = new int[N + M];
		int a1Index = 0;
		int a2Index = 0;
		int now = 0;
		
		while (!(a1Index == N && a2Index == M)) {
			if (a1Index < N && a2Index < M) {
				int n1 = a1[a1Index];
				int n2 = a2[a2Index];
				if (n1 < n2) {
					a1Index++;
					answer[now] = n1;
					now++;
				} else {
					a2Index++;
					answer[now] = n2;
					now++;
				}
			} else if (a1Index == N) {
				int n2 = a2[a2Index];
				a2Index++;
				answer[now] = n2;
				now++;
			} else if (a2Index == M) {
				int n1 = a1[a1Index];
				a1Index++;
				answer[now] = n1;
				now++;
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int x: answer) {
			sb.append(x + " ");
		}
		
		System.out.println(sb);
		
		
		
		
	}

}