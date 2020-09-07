package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Data count = fibonacci(N);
            System.out.println(count.zeroCount + " " + count.oneCount);
        }
    }

    static Data fibonacci(int N) {
        if (N == 0) { return new Data(1, 0); }
        else if (N == 1) { return new Data(0, 1); }
        else {
            int[] zero = new int[N+1];
            int[] one = new int[N+1];

            zero[0] = 1;
            zero[1] = 0;
            one[0] = 0;
            one[1] = 1;

            for(int i = 2; i <= N; i++) {
                zero[i] = zero[i-1] + zero[i-2];
                one[i] = one[i-1] + one[i-2];
            }

            return new Data(zero[N], one[N]);
        }
    }
}

class Data {
    int zeroCount;
    int oneCount;

    Data(int zeroCount, int oneCount) {
        this.zeroCount = zeroCount;
        this.oneCount = oneCount;
    }
}
