package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BAEKJOON14502 {
    // N 세로, M 가로
    static int N, M;
    static int[][] map;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static int[][] tempMap;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        tempMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    copy();
                    tempMap[i][j] = 1;
                    dfs(1);
                    tempMap[i][j] = 0;
                }
            }
        }

        System.out.println(result);

    }

    static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
    }

    static void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tempMap[i][j] == 0) {
                    tempMap[i][j] = 1;
                    dfs(wallCount+1);
                    tempMap[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 2) {
                    queueX.offer(j);
                    queueY.offer(i);
                }
            }
        }

        int[][] spreadMap = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                spreadMap[i][j] = tempMap[i][j];
            }
        }

        while (!queueX.isEmpty()) {
            int tempX = queueX.poll();
            int tempY = queueY.poll();

            for (int i = 0; i < 4; i++) {
                int destX = tempX + dir[i][1];
                int destY = tempY + dir[i][0];

                if (destX < 0 || destX >= M || destY < 0 || destY >= N) continue;
                if (spreadMap[destY][destX] != 0) continue;

                spreadMap[destY][destX] = 2;
                queueX.offer(destX);
                queueY.offer(destY);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (spreadMap[i][j] == 0) count++;
            }
        }

        if (count > result) result = count;
    }
}
