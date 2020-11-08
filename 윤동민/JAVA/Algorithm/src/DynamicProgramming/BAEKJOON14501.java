package DynamicProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+1];
        int[] P = new int[N+1];

        // i번째 날까지 일해서 받은 돈 최
        int[] DP = new int[N+2];

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        int max = DP[0];

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, DP[i]);
            DP[i] = max;

            if (i + T[i] <= N+1) {
                DP[i+T[i]] = Math.max(DP[i] + P[i], DP[i+T[i]]);
            }
        }


        max = max > DP[N+1] ? max : DP[N+1];
        System.out.println(max);
    }
}
