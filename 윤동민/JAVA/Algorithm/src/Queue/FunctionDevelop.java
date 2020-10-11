package Queue;

import java.util.ArrayList;

public class FunctionDevelop {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        solution(progresses, speeds);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int[] days = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            int day = 0;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                day++;
            }

            days[i] = day;
        }

        ArrayList<Integer> answerTemp = new ArrayList<>();

        int max = 0;
        int count = 1;

        for (int i = 1; i < days.length; i++) {
            if (days[max] >= days[i]) {
                count++;
            } else {
                answerTemp.add(count);
                max = i;
                count = 1;
            }
        }
        answerTemp.add(count);


        answer = new int[answerTemp.size()];
        for (int i = 0; i < answerTemp.size(); i++) {
            answer[i] = answerTemp.get(i);
        }

        return answer;
    }
}
