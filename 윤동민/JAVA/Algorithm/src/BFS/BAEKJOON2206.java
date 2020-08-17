package BFS;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BAEKJOON2206 {
    static int[][] map;
    static int n, m;
    static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs();
    }

    static void bfs() {
        LinkedList<Integer> queueRow = new LinkedList<>();
        LinkedList<Integer> queueCol = new LinkedList<>();
        LinkedList<Integer> queueBroken = new LinkedList<>();

        queueRow.add(0);
        queueCol.add(0);
        queueBroken.add(0);

        boolean[][][] visited = new boolean[2][n][m];
        visited[0][0][0] = true;

        int nextRow, nextCol;
        int[][][] distance = new int[2][n][m];
        distance[0][0][0] = 1;

        while (!queueRow.isEmpty()) {
            int tempRow = queueRow.removeFirst();
            int tempCol = queueCol.removeFirst();
            int tempBroken = queueBroken.removeFirst();

            for(int i = 0; i < 4; i++) {
                nextRow = tempRow + direction[i][0];
                nextCol = tempCol + direction[i][1];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m) {
                    if (map[nextRow][nextCol] == 0) {
                        if (!visited[tempBroken][nextRow][nextCol]) {
                            queueRow.add(nextRow);
                            queueCol.add(nextCol);
                            queueBroken.add(tempBroken);

                            visited[tempBroken][nextRow][nextCol] = true;
                            distance[tempBroken][nextRow][nextCol] = distance[tempBroken][tempRow][tempCol] + 1;
                        }
                    } else {
                        if (tempBroken == 0 && !visited[1][nextRow][nextCol]) {
                            queueRow.add(nextRow);
                            queueCol.add(nextCol);
                            queueBroken.add(1);

                            visited[1][nextRow][nextCol] = true;
                            distance[1][nextRow][nextCol] = distance[tempBroken][tempRow][tempCol] + 1;
                        }
                    }
                }
            }

        }

        if (distance[0][n-1][m-1] == 0 && distance[1][n-1][m-1] == 0) {
            System.out.println("-1");
            return;
        }

        if (distance[0][n-1][m-1] != 0 && distance[1][n-1][m-1] != 0) {
            System.out.println(Math.min(distance[0][n-1][m-1], distance[1][n-1][m-1]));
            return;
        } else if (distance[0][n-1][m-1] != 0) {
            System.out.println(distance[0][n-1][m-1]);
            return;
        } else {
            System.out.println(distance[1][n-1][m-1]);
            return;
        }
    }
}