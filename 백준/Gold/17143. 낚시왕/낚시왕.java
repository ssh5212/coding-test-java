import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;

	static class Shark implements Comparable<Shark> {
		int x, y, s, d, z;

		public Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Shark o) {
			return Integer.compare(this.x, o.x);
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}

	static ArrayList<Shark> shark = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 첫 번째 줄
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 상어 마리 수
		int answer = 0;
		int[][] v = new int[X + 1][Y + 1];
		for (int i = 0; i < v.length; i++) {
			Arrays.fill(v[i], -1);			
		}
		// 상 하 우 좌
		int[] dx = { 0, -1, 1, 0, 0 };
		int[] dy = { 0, 0, 0, 1, -1 };
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()); // 속도
			int d = Integer.parseInt(st.nextToken()); // 이동 방향
			int z = Integer.parseInt(st.nextToken()); // 크기

			v[x][y] = i;
			shark.add(new Shark(x, y, s, d, z));

		}

		for (int i = 1; i < Y + 1; i++) {
//			System.out.println("now : " + i);
//			print(v);
			//// 사람 턴
			// 사람이 이동하면서 잡을 상어가 있으면 잡음
			for (int j = 1; j < X + 1; j++) {
				if (v[j][i] != -1) {
					answer += shark.get(v[j][i]).z; // 무게 정보 저장
//					System.out.println(shark.get(v[j][i]).z);
					shark.remove(v[j][i]); // 상어 제거
					break;
				}
			}
//			System.out.println();

			if (i == Y)
				break;

			//// 상어 턴
			// 상어를 이동

//			v = new int[X + 1][Y + 1];
			for (int z = 0; z < v.length; z++) {
				Arrays.fill(v[z], -1);			
			}
			for (int j = 0; j < shark.size(); j++) {
				Shark nowShark = shark.get(j);

				int moveTime = 0;
				// 상하인 경우
				if (nowShark.d == 1 || nowShark.d == 2) {
					moveTime = nowShark.s % ((X - 1) * 2);
				}
				if (nowShark.d == 3 || nowShark.d == 4) {
					moveTime = nowShark.s % ((Y - 1) * 2);
				}
				int cx = nowShark.x;
				int cy = nowShark.y;
				for (int t = 0; t < moveTime; t++) {
					cx += dx[nowShark.d];
					cy += dy[nowShark.d];

					if (cx < 1 || cx > X || cy < 1 || cy > Y) {
						if (nowShark.d == 1)
							nowShark.d = 2;
						else if (nowShark.d == 2)
							nowShark.d = 1;
						else if (nowShark.d == 3)
							nowShark.d = 4;
						else if (nowShark.d == 4)
							nowShark.d = 3;

						cx = cx + 2 * dx[nowShark.d];
						cy = cy + 2 * dy[nowShark.d];
					}
				}

				nowShark.x = cx;
				nowShark.y = cy;

				// 한곳에 모이면 사냥
				if (v[nowShark.x][nowShark.y] == -1) {
					v[nowShark.x][nowShark.y] = j;
				} else {
					Shark beforeShark = shark.get(v[nowShark.x][nowShark.y]);
					if (beforeShark.z > nowShark.z) {
						shark.remove(j);
						j--;
					}
					if (beforeShark.z < nowShark.z) {
						for (int k = v[nowShark.x][nowShark.y] + 1; k < j; k++) {
							v[shark.get(k).x][shark.get(k).y]--; 
						}
						
						shark.remove(v[nowShark.x][nowShark.y]);
						j--;
						v[nowShark.x][nowShark.y] = j;
					}
				}
			} // 상어 수 만큼 반복

		} // 전체 타임
		System.out.println(answer);
	}

	private static void print(int[][] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
	}
}