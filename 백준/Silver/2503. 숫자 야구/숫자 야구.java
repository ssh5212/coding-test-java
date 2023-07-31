import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int ans = 0;

        // 첫 번째 줄 : 질문을 한 횟수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        String[] answer = new String[N];
        int[] strike = new int[N];
        int[] ball = new int[N];

        // 나머지 줄 : 질문 스트라이크 볼
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            answer[i] = st.nextToken();
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());
        }

        // 모든 숫자 반복
        F:for (int i = 100; i < 999; i++) {
            // 비교할 숫자
            String now = i + "";

            // 숫자열에 중복된 숫자가 있는 경우
            if (now.charAt(0) == now.charAt(1) || now.charAt(0) == now.charAt(2) || now.charAt(1) == now.charAt(2)) {
                continue;
            }

            if (now.charAt(0) == '0' || now.charAt(1) == '0' || now.charAt(2) == '0' ) {
                continue;
            }

            // 예측한 숫자 횟수만큼 반복
            L:for (int j = 0; j <= N; j++) {
                if (j == N) {
                    ans++;
                    break;
                }

                // 예측 숫자
                String nowAnswer = answer[j];

                int strikeCnt = 0;
                int ballCnt = 0;

                for (int k = 0; k <= 3; k++) {
                    if (k == 3) {
                        if (strike[j] == strikeCnt && strikeCnt == 3) {
                            ans = 1;
                            break F;
                        }

                        if (strike[j] == strikeCnt && ball[j] == ballCnt) {
                            continue;
                        }

                        break L;
                    }

                    if (nowAnswer.charAt(k) == now.charAt(k)) {
                        strikeCnt++;
                        continue;
                    }

                    if (nowAnswer.charAt(k) == now.charAt(0) || nowAnswer.charAt(k) == now.charAt(1) || nowAnswer.charAt(k) == now.charAt(2)) {
                        ballCnt++;
                    }

                }

            }


        }

        System.out.println(ans);

    } // [E] Main
}