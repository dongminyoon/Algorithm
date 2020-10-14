package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] sequence = new int[N];

        for (int i = 0; i < N; i++)
            sequence[i] = Integer.parseInt(input[i]);

        int[] DP = new int[N];

        for (int i = 0; i < N; i++) {
            DP[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sequence[i] > sequence[j] && DP[i] <= DP[j]) {
                    DP[i] = DP[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < DP[i]) { max = DP[i]; }
        }

        System.out.println(max);
    }
}
