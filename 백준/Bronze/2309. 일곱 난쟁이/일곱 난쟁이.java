import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] sel;
	static int[] arr;
	static int count = 7;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[9];
		sel = new int[7];
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		recursive(0, 0);
	}
	
	public static void recursive(int count, int index) {
		if (flag) return;
		if (count == 7) {
			int now = 0;
			for (int i = 0; i < sel.length; i++) {
				now += sel[i];
			}
			if (now == 100) {
				Arrays.sort(sel);
				for (int i = 0; i < sel.length; i++) {
					System.out.println(sel[i]);
				}			
				flag = true;
			}
			return;
		}
		
		for (int i = index; i < arr.length; i++) {
			sel[count] = arr[i];
			recursive(count + 1, i + 1);
			sel[count] = 0;
		}
		
		
	}
	

}