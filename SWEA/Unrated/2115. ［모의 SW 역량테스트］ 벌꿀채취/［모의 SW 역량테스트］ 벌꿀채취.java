import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, M, C;
	static int answer;
	static int[][] map;
	
	static class Best {
		int startX;
		int startY;
		int cost;
		public Best(int startX, int startY, int cost) {
			this.startX = startX;
			this.startY = startY;
			this.cost = cost;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			// 첫 번째 줄
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 크기
			M = Integer.parseInt(st.nextToken()); // 꿀벌통 크기
			C = Integer.parseInt(st.nextToken()); // 최대 꿀 무게
			
			map = new int[N][N];
			
			// 나머지 줄
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Best bestOne = new Best(-1, -1, 2);
			Best bestTwo = new Best(-1, -1, 1);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					sel = new boolean[M];
					midCost = 0;
					// 부분집합
					recursion(i, j, 0);
					
					if (bestOne.cost < midCost) {
						if(bestOne.startX == i && bestOne.startY < j && bestOne.startY + M >= j) {
							bestOne.startX = i;
							bestOne.startY = j;
							bestOne.cost = midCost;
						} else {
							bestTwo.startX = bestOne.startX; 
							bestTwo.startY = bestOne.startY; 
							bestTwo.cost = bestOne.cost;
							
							bestOne.startX = i;
							bestOne.startY = j;
							bestOne.cost = midCost;
						}
					} else if (bestTwo.cost < midCost) {
						if(!(bestOne.startX == i && bestOne.startY < j && bestOne.startY + M >= j)) {
						bestTwo.startX = i;
						bestTwo.startY = j;
						bestTwo.cost = midCost;
						}
					}
				}
			}
			answer = bestOne.cost + bestTwo.cost;
			System.out.println("#" + test_case + " " + answer);
			
		} // [E] test_case
		
	}
	
	static boolean[] sel;
	
	// 부분 집합
	private static void recursion(int x, int y, int idx) {
		if (idx == sel.length) {
			ArrayList<Integer> arr = new ArrayList<>();
			for (int i = 0; i < sel.length; i++) {
				if (sel[i] == true) {
					arr.add(map[x][y + i]);
				}
			}
			
			sel2 = new int[arr.size()];
			v2 = new boolean[arr.size()];
			recursion2(x, y, arr, 0);
			
			return;
		}
		
		
		
		sel[idx] = true;
		recursion(x, y, idx + 1);
		sel[idx] = false;
		recursion(x, y, idx + 1);
	}

	static int[] sel2;
	static boolean[] v2;
	static int midCost;
	private static void recursion2(int x, int y, ArrayList<Integer> arr, int idx) {
		if(idx == sel2.length) {
			int localWeight = 0;
			int localCost = 0;
			for (int i = 0; i < sel2.length; i++) {
				int now = sel2[i];
				localWeight += now;
				if (localWeight > C) {
					break;
				}
				localCost += now * now;
			}
			midCost = Math.max(midCost, localCost);
			
		}
		
		
		for (int i = 0; i < arr.size(); i++) {
			if (v2[i] == true) continue;
			v2[i] = true;
			sel2[idx] = arr.get(i);
			recursion2(x, y, arr, idx + 1);
			
		}
		
	}



}