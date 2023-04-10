// 길은 1, 벽은 0

import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[][] v; // 방문 배열
    static int answer;
    public int solution(int[][] maps) {
        answer = -1; // 정답의 시작 값을 -1로 지정
        v = new boolean[maps.length][maps[0].length];
        
        // 화면 출력용
        //print(maps);
        
        bfs(maps);
        
        return answer;
    }
    
    public class Point {
        int x; // x좌표
        int y; // y좌표
        int level; // 지나온 칸의 개수
            
        Point(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }  
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public void bfs(int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        
        q.offer(new Point(0, 0, 1)); // 자기 시작 위치도 포함해서 길을 개수 세야 함
        v[0][0] = true;
        
        // q가 비어있지 않은 동안 반복
        while(!q.isEmpty()) {
            Point p = q.poll();
            
            // 도착했다면
            if (p.x == maps.length - 1 && p.y == maps[0].length -1) {
                System.out.println("도착 : !! : " + p.level);
                answer = p.level;
                return;
            }
            
            // 사방 탐색
            for (int d = 0; d < dx.length; d++) {
                int nx = p.x + dx[d];                 
                int ny = p.y + dy[d];     
                
                // 맵 밖을 벗어나지 않고 / 벽이 아니며 / 방문하지 않았다면
                if (nx >=0 && nx < maps.length && ny >=0 && ny < maps[0].length 
                    && maps[nx][ny] != 0 && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.offer(new Point(nx, ny, p.level + 1));
                }
            }
        }
    }
    
    // 화면 출력용
    public void print(int[][] maps) {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }    
    
    }
}