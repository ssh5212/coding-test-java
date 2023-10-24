import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      int answer = 0;
      HashMap<String, Integer> map = new HashMap<>();
      
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         String now = st.nextToken();
         map.put(now, 1);
      }
      
      for (int i = 0; i < M; i++) {
         st = new StringTokenizer(br.readLine());
         String now = st.nextToken();
         
         
         if (map.containsKey(now) == false) {
            map.put(now, 1);
         } 
         
         // 듣도보도 못한 경우
         else {
        	 answer += 1;
            map.put(now, 2);
         }
      }
      
      List<String> keyList = new ArrayList<>(map.keySet());
      keyList.sort((a, b) -> a.compareTo(b));
      
      System.out.println(answer);
      
      for (String key: keyList) {
    	  if (map.get(key) == 2) {
    		  System.out.println(key);
    	  }
      }
      
   }

}