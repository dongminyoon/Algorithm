package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON2798 {
    static int[] cards;
    static int N, M;

    static int[] selectedCards = new int[3];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(input[i]);
        }

        dfs(0,0);

        System.out.println(max);
    }

    static void dfs(int count, int index) {
        if (count == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += selectedCards[i];
            }

            if (sum > max && sum < M) { max = sum; }
            return;
        }

        if (index >= N) {
            return;
        }

        selectedCards[count] = cards[index];
        dfs(count+1, index+1);

        selectedCards[count] = 0;
        dfs(count, index+1);
    }
}
