import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int answer;
    static List<Integer> answerList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 번째 줄
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 총 지도 크기

        map = new int[N][N];
        answer = 0;
        answerList = new LinkedList<>();

        // 나머지 줄
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = S.charAt(j) - '0';
            }
        }

        // print();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
        Collections.sort(answerList);
        for (int i = 0; i < answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }

    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static private void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
        map[i][j] = 0;
        int count = 1;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < dr.length; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && map[nr][nc] == 1) {
                    q.offer(new Point(nr, nc));
                    map[nr][nc] = 0;
                    count += 1;
                }
            }
        }
        answerList.add(count);
    }

    static private void print() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}