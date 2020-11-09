package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON9095 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            DP(Integer.parseInt(br.readLine()));
            System.out.println(count);
            count = 0;
        }

    }

    public static void DP(int N) {
        if (N == 0) {
            count++;
            return;
        }

        if (N < 0) {
            return;
        }

        DP(N-1);
        DP(N-2);
        DP(N-3);
    }
}
