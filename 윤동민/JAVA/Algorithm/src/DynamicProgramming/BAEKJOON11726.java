package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


// DP 문제 처음 접해봄
public class BAEKJOON11726 {
    static int n;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        d = new int[1001];
        d[1] = 1;
        d[2] = 2;

        System.out.println(dfs(n));
    }

    static int dfs(int length) {
        if(length == 1) { return 1; }
        if(length == 2) { return 2; }
        if(d[length] > 0) return d[length];

        d[length] = (dfs(length-1) + dfs(length-2)) % 10007;
        return d[length];
    }
}
