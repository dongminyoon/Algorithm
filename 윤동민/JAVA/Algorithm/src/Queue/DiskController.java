package Queue;
import java.util.*;

public class DiskController {
    class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;

            LinkedList<Job> queue = new LinkedList();
            for (int i = 0; i < jobs.length; i++)
                queue.offer(new Job(jobs[i][0], jobs[i][1]));

            Collections.sort(queue, (o1, o2) -> {
                if (o1.inTime == o2.inTime) o1.consumeTime.compareTo(o2.consumeTime);
                return o1.inTime.compareTo(o2.inTime);
            });

            int curTime = 0;

            while (!queue.isEmpty()) {
                LinkedList<Job> waitingList = new LinkedList<>();

                for (int i = 0; i < queue.size(); i++) {
                    if (curTime >= queue.get(i).inTime) waitingList.add(queue.get(i));
                }

                if (waitingList.isEmpty()) {
                    curTime = queue.get(0).inTime;
                } else {
                    Collections.sort(waitingList, (o1, o2) -> {
                        return o1.consumeTime.compareTo(o2.consumeTime);
                    });

                    answer += curTime - waitingList.get(0).inTime + waitingList.get(0).consumeTime;

                    System.out.println("curTime : " + curTime);
                    System.out.println("consumeTime : " + waitingList.get(0).consumeTime);
                    curTime = curTime + waitingList.get(0).consumeTime;

                    for (int i = 0; i < queue.size(); i++) {
                        if (queue.get(i) == waitingList.get(0)) {
                            queue.remove(i);
                            break;
                        }
                    }

                    waitingList.removeAll(waitingList);
                }
            }

            return answer/jobs.length;
        }
    }

    class Job {
        Integer inTime, consumeTime;

        Job(int inTime, int consumeTime) {
            this.inTime = inTime;
            this.consumeTime = consumeTime;
        }
    }
}
