class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        int add = 0;
        for(int a : arr) {
            add += a;
        }
        
        answer = (double)add / arr.length;
        System.out.println(answer);
        
        return answer;
    }
}