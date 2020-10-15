package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] sequence = new int[N];

        for (int i = 0; i < N; i++)
            sequence[i] = Integer.parseInt(input[i]);

        int[] DP = new int[N];
        int[] DP2 = new int[N];
        DP[0] = 1;
        DP2[0] = sequence[0];

        for (int i = 1; i < N; i++) {
            DP[i] = 1;
            DP2[i] = sequence[i];
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j] && DP[i] <= DP[j]) {
                    DP[i] = DP[j] + 1;
                    DP2[i] = Math.max(DP2[j] + sequence[i], DP2[i]);
                }
            }
        }

        int max = DP2[0];
        for (int i = 0; i < N; i++) {
            max = Math.max(max, DP2[i]);
        }

        System.out.println(max);
    }
}
