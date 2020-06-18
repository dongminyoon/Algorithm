package simulation;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BAEKJOON2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;

        int total_people = 0;
        int max_people = 0;

        for(int i = 0; i < 4; i++) {
            input = br.readLine().split(" ");
            total_people -= Integer.parseInt(input[0]);
            total_people += Integer.parseInt(input[1]);
            if(total_people > max_people) { max_people = total_people; }
        }

        System.out.println(max_people);
    }
}
