package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BAEKJOON3055 {
    static int R, C;
    static char[][] map;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = input[j].charAt(0);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S') {
                    bfs(i, j);
                    return;
                }
            }
        }
    }

    static void bfs(int row, int col) {
        SLocation curLocation = new SLocation(row, col, 0);

        Queue<SLocation> sQueue = new LinkedList<>();

        sQueue.offer(curLocation);

        while (!sQueue.isEmpty()) {
            waterBFS();



            for (int i = 0; i < sQueue.size(); i++) {
                SLocation tempLocation = sQueue.poll();

                for (int j = 0; j < 4; j++) {
                    SLocation next = new SLocation(tempLocation.row + direction[j][0], tempLocation.col + direction[j][1], tempLocation.count + 1);

                    if (next.row >= R
                            || next.row < 0
                            || next.col >= C
                            || next.col < 0) continue;

                    if (map[next.row][next.col] == 'D') {
                        System.out.println(next.count);
                        return;
                    }

                    if (map[next.row][next.col] != '.') continue;

                    sQueue.offer(next);
                    map[next.row][next.col] = 'S';
                }
            }
        }

        System.out.println("KAKTUS");
    }

    static void waterBFS() {
        Queue<SLocation> queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    queue.offer(new SLocation(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            SLocation temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                SLocation next = new SLocation(temp.row + direction[i][0], temp.col + direction[i][1], 0);
                if (next.row < 0
                        || next.row >= R
                        || next.col < 0
                        || next.col >= C) continue;
                if (map[next.row][next.col] != '.' && map[next.row][next.col] != 'S') continue;

                map[next.row][next.col] = '*';
            }
        }

    }
}

class SLocation {
    int row, col;
    int count;

    SLocation(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }
}
