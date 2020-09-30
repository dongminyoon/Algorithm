package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON1912 {
    static int N;
    static int[] numbers;
    static int max = -1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[N];
        dp[0] = numbers[0];
        max = numbers[0];

        for(int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i-1] + numbers[i], numbers[i]);
            max = Math.max(dp[i], max);
        }


        System.out.println(max);
    }
}
