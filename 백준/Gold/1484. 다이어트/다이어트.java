import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int G = Integer.parseInt(st.nextToken());
		boolean flag = false;
		
		int lt = 1;
		int rt = 2;
		while (!(lt == rt)) {
			int l = lt * lt;
			int r = rt * rt;
			
			if (r - l == G) {
				System.out.println(rt);
				flag = true;
				lt++;
			} else if (r - l > G) {
				lt++;
			} else {
				rt++;
			}
		}
		
		if (flag == false) {
			System.out.println(-1);
		}
	}

}