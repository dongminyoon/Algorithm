package Queue;

import java.util.LinkedList;

public class Truck {
    public static void main(String[] args) {
        int[] truck = {7, 4, 5, 6};
        solution(2, 10, truck);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int leftWeight = weight;

        // 들어온 트럭
        int inTruck = 0;
        int outTruck = 0;

        LinkedList<Integer> queue = new LinkedList<>();

        while (outTruck != truck_weights.length) {
            if (!queue.isEmpty()) {
                for (int j = 0; j < queue.size(); j++) {
                    queue.set(j, queue.get(j) - 1);
                }

                if (queue.getFirst() == 0) {
                    queue.removeFirst();
                    leftWeight += truck_weights[outTruck];
                    outTruck++;
                }
            }

            if (inTruck < truck_weights.length) {
                if (leftWeight - truck_weights[inTruck] >= 0) {
                    queue.add(bridge_length);
                    leftWeight -= truck_weights[inTruck];
                    inTruck++;
                }
            }

            answer++;
        }

        System.out.println(answer);

        return answer;
    }
}
