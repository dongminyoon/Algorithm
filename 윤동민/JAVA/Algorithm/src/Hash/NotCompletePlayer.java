package Hash;

import java.util.HashMap;

public class NotCompletePlayer {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> isComplete = new HashMap<>();

        for (String each : participant) {
            if (isComplete.containsKey(each)) {
                isComplete.put(each, isComplete.get(each) + 1);
            } else {
                isComplete.put(each, 1);
            }
        }

        for (String each : completion) {
            isComplete.put(each, isComplete.get(each) - 1);
        }

        for (String key : isComplete.keySet()) {
            if (isComplete.get(key) != 0) { return key; }
        }

        return answer;
    }
}
