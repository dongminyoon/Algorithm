package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEKJOON10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        ArrayList<Integer> stack = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            String input = br.readLine();

            if (input.equals("0")) {
                if (stack.isEmpty()) continue;
                stack.remove(stack.size()-1);
            } else {
                stack.add(Integer.parseInt(input));
            }
        }

        int answer = 0;
        for (int i = 0; i < stack.size(); i++) answer += stack.get(i);

        System.out.println(answer);
    }
}
