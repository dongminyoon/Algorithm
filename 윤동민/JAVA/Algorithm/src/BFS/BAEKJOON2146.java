package BFS;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BAEKJOON2146 {
    static int n;
    static int[][] map;

    static int[][] direction = {{1, 0}, {0, 1}, {-1 ,0}, {0, -1}};

    static int islandNum = 2;

    static int islandBridgeCount = 9999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }


        // 각 섬별로 번호 매기는 작
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1) {
                    setIslandNumber(i, j);
                    islandNum += 1;
                }
            }
        }

        // 각 섬별로 가장 작은 다리 찾기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] != 0) {
                    bfs(map[i][j], i, j);
                }
            }
        }

        System.out.println(islandBridgeCount);
    }

    // 섬별로 번호 매기기
    static void setIslandNumber(int row, int col) {
        LinkedList<Integer> queueRow = new LinkedList<>();
        LinkedList<Integer> queueCol = new LinkedList<>();

        boolean[][] visited = new boolean[n][n];

        int nextRow, nextCol;

        visited[row][col] = true;
        map[row][col] = islandNum;

        queueRow.add(row);
        queueCol.add(col);

        while (!queueRow.isEmpty()) {
            int tempRow = queueRow.removeFirst();
            int tempCol = queueCol.removeFirst();

            for(int i = 0; i < 4; i++) {
                nextRow = tempRow + direction[i][0];
                nextCol = tempCol + direction[i][1];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
                    if (map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                        queueRow.add(nextRow);
                        queueCol.add(nextCol);

                        map[nextRow][nextCol] = islandNum;
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
    }

    static void bfs(int crnIslandNum, int row, int col) {
        LinkedList<Integer> queueRow = new LinkedList<>();
        LinkedList<Integer> queueCol = new LinkedList<>();

        boolean[][] visited = new boolean[n][n];
        int[][] distance = new int[n][n];

        queueRow.add(row);
        queueCol.add(col);
        visited[row][col] = true;

        int nextRow, nextCol;

        while (!queueRow.isEmpty()) {
            int tempRow = queueRow.removeFirst();
            int tempCol = queueCol.removeFirst();

            for(int i = 0; i < 4; i++) {
                nextRow = tempRow + direction[i][0];
                nextCol = tempCol + direction[i][1];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
                    if (crnIslandNum == map[nextRow][nextCol]) continue;
                    if (visited[nextRow][nextCol]) continue;
                    if (map[nextRow][nextCol] == 0) {
                        distance[nextRow][nextCol] = distance[tempRow][tempCol] + 1;
                        visited[nextRow][nextCol] = true;

                        queueRow.add(nextRow);
                        queueCol.add(nextCol);
                        continue;
                    }

                    if (crnIslandNum != map[nextRow][nextCol]) {
                        islandBridgeCount = Math.min(islandBridgeCount, distance[tempRow][tempCol]);
                        return;
                    }
                }
            }
        }
    }
}
