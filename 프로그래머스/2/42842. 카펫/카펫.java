class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int yh = 0;
        int yw = 1;
        while(true) {
            yh += 1;
            
            if (yellow % yh != 0) {
                continue;
            }
            
            yw = yellow / yh;
            if (yh > yw) {
                break;
            }
            
            if ((yw + 2) * 2 + (yh * 2) == brown) {
                answer[0] = yw + 2;
                answer[1] = yh + 2;
                break;
            }
        }
        
        return answer;
    }
}