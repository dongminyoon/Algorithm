package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BAEKJOON2178 {
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] pathCount;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N+1][M+1];
        pathCount = new int[N+1][M+1];
        pathCount[1][1] = 1;

        for(int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i+1][j+1] = Integer.parseInt(input[j]);
            }
        }

        bfs(N, M);
    }

    static void bfs(int N, int M) {
        Queue<Dot> queue= new LinkedList<>();
        boolean[][] visited = new boolean[N+1][M+1];

        Dot startDot = new Dot(1, 1);
        queue.offer(startDot);

        visited[1][1] = true;

        while (!queue.isEmpty()) {
            Dot tempDot = queue.poll();

            for(int i = 0; i < 4; i++) {
                Dot destDot = new Dot(tempDot.x + dir[i][1], tempDot.y + dir[i][0]);

                if (destDot.x < 1 || destDot.x > M || destDot.y < 1 || destDot.y > N) { continue; }
                if (visited[destDot.y][destDot.x] || map[destDot.y][destDot.x] == 0) { continue; }

                queue.offer(destDot);
                visited[destDot.y][destDot.x] = true;
                pathCount[destDot.y][destDot.x] = pathCount[tempDot.y][tempDot.x] + 1;
            }
        }

        System.out.println(pathCount[N][M]);
    }
}

class Dot {
    int x, y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
