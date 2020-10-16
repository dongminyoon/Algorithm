package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] DP = new int[N+1][10];


        for (int i = 1; i <= 9; i++) {
            DP[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    DP[i][j] = DP[i-1][1] % 1000000000;
                } else if (j == 9) {
                    DP[i][j] = DP[i-1][8] % 1000000000;
                } else {
                    DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1]) % 1000000000;
                }
            }
        }


        long answer = 0;
        for (int i = 0; i <= 9; i++)
            answer += DP[N][i];

        System.out.println(answer%1000000000);
    }
}
