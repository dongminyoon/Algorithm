package Queue;
import java.util.*;

public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        LinkedList<Integer> queue = new LinkedList<>();

        Integer curMax = 0;
        Integer curMin = 0;

        for (String operation : operations) {
            String[] instructions = operation.split(" ");

            if (instructions[0].equals("I")) {
                int number = Integer.parseInt(instructions[1]);
                if (queue.isEmpty()) {
                    curMax = number;
                    curMin = number;
                } else {
                    if (number > curMax) curMax = number;
                    if (number < curMin) { curMin = number; }
                }

                queue.add(number);
            } else {
                if (queue.size() == 1) {
                    queue.remove(0);
                    curMin = 0;
                    curMax = 0;
                } else {
                    if (instructions[1].equals("1")) {
                        if (queue.isEmpty()) continue;
                        queue.remove(curMax);

                        int max = queue.get(0);
                        for (Integer element : queue) {
                            if (max < element) max = element;
                        }

                        curMax = max;
                        System.out.println("max" + " " + curMax);
                    } else {
                        if (queue.isEmpty()) continue;
                        queue.remove(curMin);

                        int min = queue.get(0);
                        for (Integer element : queue) {
                            if (min > element) min = element;
                        }

                        curMin = min;
                        System.out.println("min" + " " + curMin);
                    }
                }
            }
        }

        if (queue.isEmpty()) return new int[] {0, 0};

        return new int[] {curMax, curMin};
    }
}
