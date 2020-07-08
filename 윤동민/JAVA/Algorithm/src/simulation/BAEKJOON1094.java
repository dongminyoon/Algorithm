package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int initial_line = 64;
        int x = Integer.parseInt(br.readLine());

        int total = 0;
        int count = 0;

        while (total != x) {
            if (total + initial_line > x) {
                initial_line /= 2;
            } else {
                count++;
                total += initial_line;
            }
        }

        System.out.println(count);
    }
}
