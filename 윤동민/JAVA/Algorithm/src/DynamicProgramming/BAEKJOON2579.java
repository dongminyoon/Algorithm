package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON2579 {
    static int n;
    static int[] points;
    static int[] total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        points = new int[n+1];

        for(int i = 1; i < n+1; i++) { points[i] = Integer.parseInt(br.readLine()); }

    }

    static void dfs(int currentStair, int continueCount) {
        if (currentStair == 0) { return; }

        if (currentStair-1)

        // 2개의 칸을 이미 연속으로 밟은 경우
        if (continueCount == 2 && currentStair-2 < 0) {
            total[currentStair-2] = total[currentStair] + points[currentStair-2];
            dfs(currentStair-2, 0);
        } else if (points[currentStair-1] > points[currentStair-2]) {

        }





        continueCount += 1;


    }
}
