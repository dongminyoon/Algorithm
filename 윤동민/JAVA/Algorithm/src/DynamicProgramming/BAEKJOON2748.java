package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n <= 1) {
            System.out.println(n);
            return;
        }

        long[] DP = new long[n+1];
        DP[0] = 0;
        DP[1] = 1;

        for (int i = 2; i <= n; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }

        System.out.println(DP[n]);
    }
}
