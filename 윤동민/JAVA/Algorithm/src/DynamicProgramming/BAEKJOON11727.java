package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 대충은 알겠는데 n = 3일 때, 5가지 경우여야 되는거 아닌가.? 뭐가 더 있
public class BAEKJOON11727 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[] tile = new int[1001];
        tile[1] = 1;
        tile[2] = 3;

        for(int i = 3; i < tile.length; i++) {
            tile[i] = (tile[i-1] + 2*tile[i-2]) % 10007;
        }

        System.out.println(tile[n]);
    }
}
