class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        answer = new int[2];
        
        int x = 0;
        int y = 0;        
        
        char[][] map = new char[park.length][park[0].length()];
        
        // map 생성
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = park[i].charAt(j);
                if (map[i][j] == 'S') {
                    map[i][j] = 'O';
                    x = i;
                    y = j;
                }
            }
        }
        // print(map);
        
        // routes 반복
        for (int i = 0; i < routes.length; i++) {
            char rot_char = routes[i].charAt(0);
            int rot = 0;
            int range = routes[i].charAt(2) - '0';
            
            if (rot_char == 'E') {
                rot = 0;
            }
            else if (rot_char == 'W') {
                rot = 1;
            }
            else if (rot_char == 'S') {
                rot = 2;
            }
            else if (rot_char == 'N') {
                rot = 3;
            }
            

            for (int d = 1; d <= range + 1; d++) {
                if (d == range + 1) {
                    x = x + ( dx[rot] * (d - 1) );
                    y = y + ( dy[rot] * (d - 1) );
                    
                    break;
                }
                
                int nx = x + ( dx[rot] * d ); 
                int ny = y + ( dy[rot] * d ); 
                
                if (!(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length 
                    && map[nx][ny] == 'O' )) {
                    System.out.println(x + " : " + y);
                    break;
                } 
                
            }   
            
        }
        
        answer[0] = x;
        answer[1] = y;
        
        
        return answer;
    }
    
    public static void print(char map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}