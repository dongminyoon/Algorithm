import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class main {
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static String[][] map;
    static int r, c;

    static ArrayList<Integer> counts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        main.r = r;
        main.c = c;

        String[][] map = new String[r][c];
        for(int i = 0; i < r; i++) {
            input = br.readLine().split("");
            for(int j = 0; j < c; j++) {
                map[i][j] = input[j];
            }
        }

        main.map = map;
        boolean[] visited = new boolean[26];
        int visitedAlpa = (int)map[0][0].charAt(0) - 65;
        visited[visitedAlpa] = true;

        dfs(0, 0, 1, visited);

        Collections.sort(counts);
        System.out.print(counts.get(counts.size()-1));
    }

    static void dfs(int row, int col, int count, boolean[] visited) {
        Boolean isGo = false;
        int nextRow, nextCol;
        for(int i = 0; i < 4; i++) {
            nextRow = row + direction[i][0];
            nextCol = col + direction[i][1];

            if (nextRow >= 0 && nextRow < r && nextCol >= 0 && nextCol < c) {
                int visitedNextAlpa = (int)map[nextRow][nextCol].charAt(0) - 65;
                if (!visited[visitedNextAlpa]) {
                    visited[visitedNextAlpa] = true;
                    count++;
                    dfs(nextRow, nextCol, count, visited);
                    count--;
                    visited[visitedNextAlpa] = false;
                    isGo = true;
                }
            }
        }

        if (!isGo) {
            counts.add(count);
            return;
        }
    }
}
