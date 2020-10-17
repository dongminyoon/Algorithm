package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    static int[][] computerMap;
    static int N;

    public static void main(String[] args) {
        solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }

    public static int solution(int n, int[][] computers) {
        int answer;

        computerMap = computers;
        N = n;

        answer = bfs();

        return answer;
    }

    public static int bfs() {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int curCom = queue.poll();

                for (int j = 0; j < N; j++) {
                    if (computerMap[curCom][j] != 1 || curCom == j || visited[j]) continue;
                    visited[j] = true;
                    queue.offer(j);
                }
            }

            count++;
        }


        return count;
    }
}
