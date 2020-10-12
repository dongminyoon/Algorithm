package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        int[] priority = {1, 1, 9, 1, 1, 1};

        solution(priority, 0);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 1;

        Queue<Document> queue = new LinkedList<>();

        HashMap<Integer, Integer> priorityMap = new HashMap<>();
        int max = priorities[0];

        // 초기화
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(i, priorities[i]));

            if (priorityMap.containsKey(priorities[i])) {
                priorityMap.put(priorities[i], priorityMap.get(priorities[i]) + 1);
            } else {
                priorityMap.put(priorities[i], 1);
            }

            if (max < priorities[i]) { max = priorities[i]; }
        }


        while (!queue.isEmpty()) {
            Document temp = queue.poll();

            if (temp.priority == max) {
                if (temp.index == location) break;
                answer++;

                if (priorityMap.get(temp.priority) == 1) {
                    priorityMap.remove(temp.priority);

                    max = 0;
                    for (Integer key : priorityMap.keySet())
                        if (max < key) { max = key; }
                } else {
                    priorityMap.put(temp.priority, priorityMap.get(temp.priority) - 1);
                }
            } else {
                queue.offer(temp);
            }
        }

        System.out.println(answer);

        return answer;
    }
}

class Document {
    int index;
    int priority;

    Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}
