package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON13460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        // N = 가로, M = 세
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String[][] map = new String[N][M];

        for(int i = 0; i < N; i++) {
            input = br.readLine().split("\\s");
            for(int j = 0; j < M; j++) {
                map[i][j] = input[j];
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.println("");
            for(int j = 0; j < M; j++) {
                System.out.println(map[i][j] + " ");
            }
        }
    }
}
