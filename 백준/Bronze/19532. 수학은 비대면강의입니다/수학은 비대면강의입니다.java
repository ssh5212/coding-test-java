import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int A, B, C, D, E, F;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        for (int x = -10000; x < 10001; x++) {
            for (int y = -10000; y < 10001; y++) {
                if ((A*x + B*y == C) && (D*x + E*y == F)) {
                    System.out.println(x + " " + y);
                }
            }
        }

    }
}