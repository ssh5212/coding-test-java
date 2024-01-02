import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] arr = new int[1000001];
		
		int[] counter = new int[10];
		int arrNow = 1;
		int tmp = 1; // 현재 찾고 있는 값
		int tmpCopy = 1; // 현재 찾고 있는 값 복사
		while(arr[1000000] == 0) {
			tmpCopy = tmp;
			Arrays.fill(counter, 0);
			while(true) {
				int now = tmpCopy % 10;
				if (tmpCopy / 10 == 0) {
					counter[now]++;
					if (counter[now] >= 2) {
						tmp++;
						break;
					} else {
						arr[arrNow] = tmp;
						tmp++;
						arrNow++;
						break;
					}
				} 
				else {
					
					counter[now]++;
					if (counter[now] >= 2) {
						tmp++;
						break;
					} else {
						tmpCopy = tmpCopy / 10;
					}
				}
			}
		}
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
			if (tc == 0) break;
			System.out.println(arr[tc]);
		}

	}

}