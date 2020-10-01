package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] grapeAmount = new int[N];

        for(int i = 0; i < N; i++) {
            grapeAmount[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(grapeAmount[0]);
            return;
        } else if (N == 2) {
            System.out.println(grapeAmount[0] + grapeAmount[1]);
            return;
        } else if (N == 3) {
            int max = Math.max(grapeAmount[0] + grapeAmount[1], grapeAmount[0] + grapeAmount[2]);
            max = Math.max(max, grapeAmount[1] + grapeAmount[2]);
            System.out.println(max);
            return;
        }

        int[] dp = new int[N];
        dp[0] = grapeAmount[0];
        dp[1] = grapeAmount[0] + grapeAmount[1];
        int max = Math.max(grapeAmount[0] + grapeAmount[1], grapeAmount[0] + grapeAmount[2]);
        max = Math.max(max, grapeAmount[1] + grapeAmount[2]);
        dp[2] = max;

        for(int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i-2] + grapeAmount[i], grapeAmount[i-1] + dp[i-3] + grapeAmount[i]);
        }

        System.out.println(Math.max(dp[N-1], dp[N-2]));
    }
}
