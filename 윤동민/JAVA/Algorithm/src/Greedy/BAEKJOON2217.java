package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BAEKJOON2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];

        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(weights);
        int max = 0;

        for (int i = 0; i < N; i++) {
            int totalWeight = weights[i] * (N-i);
            if (totalWeight > max) { max = totalWeight; }
        }

        System.out.println(max);
    }
}
