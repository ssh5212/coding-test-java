import java.io.*;
import java.util.*;

public class Main {
	
	public static int solution(int N, int M, int K) {
		int answer = 0;
				
		int before = Math.min(M, N/2); // 인턴 나가는 학생 빼기 전 최대 팀원 수
		
		int dump = N - (before * 2) + (M - before);
		
		int intern = K - dump;
		
		if (intern > 0) {
			answer = before - (intern / 3);
			if (intern % 3 != 0) answer -= 1;
			if (answer < 0) {
				answer = 0;
			}
			
			
		} else {
			answer = before;
		}
		
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 여학생
		int M = Integer.parseInt(st.nextToken()); // 남학생
		int K = Integer.parseInt(st.nextToken()); // 인턴 참여 인원
		
		int answer = solution(N, M, K);
		
		System.out.println(answer);

	}

}