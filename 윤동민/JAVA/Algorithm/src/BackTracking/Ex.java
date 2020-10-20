package BackTracking;

import java.util.*;

public class Ex {
    public static void main(String[] args) {
        LinkedList<JOB> queue = new LinkedList<>();

        LinkedList<JOB> queue1 = new LinkedList<>();


        queue.remove(queue1.get(0));


        Collections.sort(queue, Comparator.comparing(o -> o.inTime));
    }
}

class JOB {
    Integer inTime;

    JOB(int inTime) {
        this.inTime = inTime;
    }
}
