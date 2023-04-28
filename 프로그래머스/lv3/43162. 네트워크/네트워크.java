class Solution {
    
    static boolean[] v; // 컴퓨터를 방문한적이 있는지를 체크하는 배열
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        v = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (v[i] == false) {
                dfs(i, computers);     
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int now, int[][] map) {
        v[now] = true;
        
        for (int i = 0; i < v.length; i++) {
            if(map[now][i] == 1 && v[i] == false) {
                dfs(i, map);
            }
        }
        
    }
    
}