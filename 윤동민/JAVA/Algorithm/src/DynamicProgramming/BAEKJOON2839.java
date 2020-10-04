package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int fiveCount = 0;
        int threeCount = 0;

        while (true) {
            if (N < 0) {
                System.out.println(-1);
                return;
            }

            if (N % 5 == 0) {
                fiveCount += N/5;
                break;
            }

            threeCount += 1;
            N -= 3;
        }

        System.out.println(threeCount+fiveCount);
    }
}
