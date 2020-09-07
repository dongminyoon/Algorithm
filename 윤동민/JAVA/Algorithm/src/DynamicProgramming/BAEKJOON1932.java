package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON1932 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] triangle = new int[N][];

        for(int i = 0; i < N; i++) {
            triangle[i] = new int[i+1];
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < i+1; j++) {
                triangle[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(findMax(triangle));
    }

    static int findMax(int[][] triangle) {
        if (N == 1) return triangle[0][0];

        int[][] result = new int[N][];
        result[0] = new int[1];
        result[0][0] = triangle[0][0];

        for(int i = 1; i < N; i++) {
            result[i] = new int[i+1];

            for(int j = 0; j < i+1; j++) {
                if (j == 0) { result[i][j] = result[i-1][j] + triangle[i][j]; }
                else if (j == i) { result[i][j] = result[i-1][j-1] + triangle[i][j]; }
                else {
                    result[i][j] = Math.max(result[i-1][j-1], result[i-1][j]) + triangle[i][j];
                }
            }
        }

        int max = result[N-1][0];

        for(int i = 1; i < N; i++) {
            if (result[N-1][i] > max) { max = result[N-1][i]; }
        }

        return max;
    }

}
