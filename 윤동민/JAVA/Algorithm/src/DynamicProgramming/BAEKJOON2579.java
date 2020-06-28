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
        total = new int[n+1];

        for(int i = 1; i < n+1; i++) { points[i] = Integer.parseInt(br.readLine()); }

        if (n == 1) {
            System.out.println(points[n]);
            return;
        } else if (n == 2) {
            System.out.println(points[n] + points[n-1]);
            return;
        } else if (n == 3) {
            System.out.println(Math.max(points[1] + points[3], points[2] + points[3]));
            return;
        }

        total[1] = points[1];
        total[2] = points[1] + points[2];
        total[3] = Math.max(points[1] + points[3], points[2] + points[3]);

        for(int i = 4; i < n+1; i++) {
            total[i] = Math.max(total[i-3] + points[i-1] + points[i], total[i-2] + points[i]);
        }

        System.out.println(total[n]);
    }
}
