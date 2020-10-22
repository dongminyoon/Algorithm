package BruteForce;

import java.util.*;

public class SearchPrime {
    boolean[] visited;
    int[] number_set;
    ArrayList<Integer> answers = new ArrayList<>();

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        number_set = new int[numbers.length()];

        for (int i = 0; i < numbers.length(); i++)
            number_set[i] = numbers.charAt(i) - '0';

        dfs(0, "");


        return answers.size();
    }

    public void dfs(int count, String number) {
        if (count == number_set.length && !number.equals("")) {
            int convert_number = Integer.parseInt(number);
            if (isPrime(convert_number) && !answers.contains(convert_number))
                answers.add(convert_number);
            return;
        }

        for (int i = 0; i < number_set.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(count+1, number+Integer.toString(number_set[i]));
            dfs(count+1, number);
            visited[i] = false;
        }
    }

    public boolean isPrime(int number) {
        if (number == 0) return false;
        if (number == 1) return false;
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0) return false;

        for (int i = 3; i < number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
