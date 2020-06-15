package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON11047 {
    static int n, k;
    static int[] values_Of_Coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        values_Of_Coin = new int[n];

        for(int i = 0; i < n; i++) {
            values_Of_Coin[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0, 0);

    }

    static void dfs(int index, int count, int total) {
        if(total == k) {
            System.out.println(total);
            return;
        }

        if(total > k) {return ;}

        total += values_Of_Coin[index];
        count++;

        dfs(index, count, total);
        if(index+1 < n) { dfs(index++, count, total); }
    }
}
