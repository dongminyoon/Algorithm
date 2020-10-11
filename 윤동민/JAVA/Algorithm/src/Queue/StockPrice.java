package Queue;

import java.util.LinkedList;

public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3, 3, 1};

        solution(prices);
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {
            int curPrice = prices[i];

            for (int j = stack.size()-1; j >= 0; j--) {
                answer[stack.get(j)] += 1;
                if (curPrice < prices[stack.get(j)]) {
                    stack.remove(j);
                }
            }

            stack.add(i);
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }

        return answer;
    }
}
