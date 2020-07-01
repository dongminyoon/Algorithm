package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BAEKJOON10026 {
    static int n;
    static String[][] grid;
    static boolean[][] isVisited;

    static int[][] direction = {{1,0}, {0, 1}, {-1, 0}, {0,-1}};
    static int not_Count = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        grid = new String[n][n];
        isVisited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                grid[i][j] = Character.toString(input.charAt(j));
            }
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (!isVisited[i][j]) { bfs(j, i); }
            }
        }

        isVisited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (!isVisited[i][j]) { weakenessBFS(j, i); }
            }
        }

        System.out.println(not_Count + " " + count);

    }

    static void bfs(int startX, int startY) {
        LinkedList<Integer> queueX = new LinkedList<>();
        LinkedList<Integer> queueY = new LinkedList<>();

        isVisited[startY][startX] = true;
        queueX.add(startX);
        queueY.add(startY);

        String separateRGB = grid[startY][startX];

        while (!queueX.isEmpty()) {
            int tempX = queueX.removeFirst();
            int tempY = queueY.removeFirst();

            for(int i = 0; i < 4; i++) {
                int nextX = tempX + direction[i][1];
                int nextY = tempY + direction[i][0];

                if (nextX < n && nextX >= 0 && nextY < n && nextY >= 0 &&
                        !isVisited[nextY][nextX] && separateRGB.equals(grid[nextY][nextX])) {
                    isVisited[nextY][nextX] = true;
                    queueX.add(nextX);
                    queueY.add(nextY);
                }
            }
        }

        not_Count++;
    }

    static void weakenessBFS(int startX, int startY) {
        LinkedList<Integer> queueX = new LinkedList<>();
        LinkedList<Integer> queueY = new LinkedList<>();

        isVisited[startY][startX] = true;
        queueX.add(startX);
        queueY.add(startY);

        String separateRGB = grid[startY][startX];

        while (!queueX.isEmpty()) {
            int tempX = queueX.removeFirst();
            int tempY = queueY.removeFirst();

            for(int i = 0; i < 4; i++) {
                int nextX = tempX + direction[i][1];
                int nextY = tempY + direction[i][0];

                if (nextX < n && nextX >= 0 && nextY < n && nextY >= 0 &&
                        !isVisited[nextY][nextX]) {
                    if (separateRGB.equals("R") || separateRGB.equals("G")) {
                        if (grid[nextY][nextX].equals("R") || grid[nextY][nextX].equals("G")) {
                            isVisited[nextY][nextX] = true;
                            queueY.add(nextY);
                            queueX.add(nextX);
                        }
                    } else {
                        if (grid[nextY][nextX].equals("B")) {
                            isVisited[nextY][nextX] = true;
                            queueY.add(nextY);
                            queueX.add(nextX);
                        }
                    }
                }
            }
        }

        count++;
    }
}
