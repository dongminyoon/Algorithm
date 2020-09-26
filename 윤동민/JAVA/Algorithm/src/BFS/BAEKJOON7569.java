package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BAEKJOON7569 {
    static int N, M, H;
    static int[][][] map;
    static int[][][] day;

    static int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);

        map = new int[H][N][M];
        day = new int[H][N][M];

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                input = br.readLine().split(" ");
                for(int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(input[k]);
                }
            }
        }

        if (isComplte()) {
            System.out.println("0");
            return;
        } else {
            bfs();


            int count = 0;
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < N; j++) {
                    for(int k = 0; k < M; k++) {
                        if (map[i][j][k] == 0) {
                            System.out.println("-1");
                            return;
                        }

                        if (count < day[i][j][k]) count = day[i][j][k];
                    }
                }
            }

            System.out.println(count);
        }
    }


    static boolean isComplte() {
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) { return false; }
                }
            }
        }

        return true;
    }

    static void bfs() {
        Queue<Location> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 1) {
                        queue.offer(new Location(k, j, i));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Location temp = queue.poll();

            for (int i = 0; i < 6; i++) {
                int destX = temp.x + dir[i][2];
                int destY = temp.y + dir[i][1];
                int destZ = temp.z + dir[i][0];

                if (destX >= 0 && destX < M && destY >= 0 && destY < N && destZ >= 0 && destZ < H && map[destZ][destY][destX] == 0) {
                    queue.offer(new Location(destX,destY,destZ));
                    map[destZ][destY][destX] = 1;
                    day[destZ][destY][destX] = day[temp.z][temp.y][temp.x] + 1;
                }
            }
        }
    }
}

class Location {
    int x, y, z;

    Location(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
