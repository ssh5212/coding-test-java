import java.io.*;
import java.util.*;

class Solution {
    public Integer[] solution(int[] numbers) {
        Integer[] answer = {};
        
        // set 생성
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
                
            }
        }
        
        // System.out.println(set);
        
        // set -> array
        answer = set.toArray(new Integer[0]);
        
        Arrays.sort(answer);
        
        return answer;
    }
}