package BruteForce;

import java.util.*;

public class MockExam {
    public int[] solution(int[] answers) {
        int[][] persons = {{1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < persons.length; i++) {
            int count = 0;
            for (int j = 0; j < answers.length; j++) {
                if (persons[i][j%persons[i].length] == answers[j]) count++;
            }
            if (count > max) max = count;
            map.put(i+1, count);
        }


        ArrayList<Integer> temp = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == max) temp.add(entry.getKey());

        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }
}
