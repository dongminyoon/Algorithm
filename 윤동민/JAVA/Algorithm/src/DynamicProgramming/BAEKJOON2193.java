package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON2193 {
    static int n;
    static long[] zero_count;
    static long[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        zero_count = new long[91];
        count = new long[91];

        count[1] = 1;
        count[2] = 1;
        count[3] = 2;

        zero_count[1] = 0;
        zero_count[2] = 1;
        zero_count[3] = 1;


        for(int i = 4; i < n+1; i++) {
            count[i] = count[i-1] + zero_count[i-1];
            zero_count[i] = zero_count[i-1] + (count[i-1] - zero_count[i-1]);
        }

        System.out.println(count[n]);

    }
}
