package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 그리디 알고리즘이란?
// 매순간 최선의 선택을 하여 결론을 도출해내는 과정을 나타내는 알고리즘이다

// 여기서 동전 사용의 최솟값을 구하기 위해서는 가장 큰 값을 먼저 찾아내는 과정에서 Total에 값을 더하면서 비교한다
// 큰 값을 더하면서 도출해내는 과정에서 최솟값이 나온다
// DFS을 사용할 필요가 없다

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


        int total = 0;
        int count = 0;

        while (total < k) {
            for(int i = n-1; i >= 0; i--) {
                if (total + values_Of_Coin[i] <= k) {
                    count++;
                    total += values_Of_Coin[i];
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
