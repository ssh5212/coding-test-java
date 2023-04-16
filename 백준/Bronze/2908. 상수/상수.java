import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String num1 = st.nextToken();
		String num2 = st.nextToken();

		String answer = "";

		for (int i = 2; i >= 0; i--) {
			if (num1.charAt(i) == num2.charAt(i)) {
				continue;
			}
			if (num1.charAt(i) > num2.charAt(i)) {
				for (int j = 2; j >= 0; j--) {
					answer += num1.charAt(j);
				}
				break;
			}

			if (num1.charAt(i) < num2.charAt(i)) {
				for (int j = 2; j >= 0; j--) {
					answer += num2.charAt(j);
				}
				break;
			}
		}
		System.out.println(answer);
	}
}