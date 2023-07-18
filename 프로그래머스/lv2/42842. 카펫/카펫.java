// h(높이)가 1일때부터 반복
// h(높이)가 w(너비)보다 크면 종료
// w = y/2;
// brown 개수 확인법 : ((w + 2) * 2) + (h * 2)
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer = new int[2];
        
        int w = 0;
        int h = 0;
        
        boolean flag = true;
        while(flag && Integer.MAX_VALUE > h) {
            // System.out.println("h : " + h);
            
            h += 1;            
            
            // 해당 높이로 사각형을 만들 수 없다면 continue;
            if (yellow % h != 0) {
                continue;
            }

            w = yellow / h;
            // System.out.println("w : " + w);
            
            // h가 w보다 크다면 break;
            if (h > w) {
                break;
            }
            
            int nowBrown = ((w + 2) * 2) + (h * 2);
            // brown을 만들 수 없다면 continue
            if (nowBrown != brown) {
                continue;
            } 
            // brown을 만들 수 있다면 answer update
            else {
                answer[0] = w + 2;
                answer[1] = h + 2;
                continue;
            }
        }
        
        return answer;
    }
}