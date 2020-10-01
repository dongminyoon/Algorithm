package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] grapeAmount = new int[N];
        int[] dp = new int[N+1];

        for(int i = 0; i < N; i++) {
            grapeAmount[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = grapeAmount[0];
        if (N == 1) {
            System.out.println(dp[1]);
            return;
        }

        dp[2] = grapeAmount[1] + dp[1];
        if (N == 2) {
            System.out.println(dp[2]);
            return;
        }

        for(int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-2] + grapeAmount[i-1], grapeAmount[i-2] + dp[i-3] + grapeAmount[i-1]);
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        System.out.println(dp[N]);
    }
}
