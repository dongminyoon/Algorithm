package BackTracking;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BAEKJOON1799 {
    static int max_Black = 0;
    static int max_White = 0;
    static int[][] map;
    static int n;

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

        boolean[][] visited = new boolean[n][n];
        dfs_black(visited, 0, 0);
        dfs_white(visited, 0, 1);

        System.out.println(max_Black + max_White);
    }

    static void dfs_white(boolean[][] visited, int currentRow, int currentCol) {
        if (currentCol >= n) {
            currentCol = (currentRow+1) % 2 == 0 ? 1 : 0;
            currentRow++;
        }

        if (currentRow >= n) {
            int m = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (visited[i][j]) { m++; }
                }
            }

            if (max_White < m) { max_White = m; }
            return;
        }

        if(!visited[currentRow][currentCol] && map[currentRow][currentCol] == 1 && searchArroundBishop(visited, currentRow, currentCol)) {
            visited[currentRow][currentCol] = true;
            dfs_white(visited, currentRow, currentCol);
            visited[currentRow][currentCol] = false;
        }

        dfs_white(visited, currentRow, currentCol+2);
    }

    static void dfs_black(boolean[][] visited, int currentRow, int currentCol) {
        // Row, Col 모두 짝수 또는 홀수인 경
        if (currentCol >= n) {
            currentCol = (currentRow+1) % 2 == 0 ? 0 : 1;
            currentRow++;
        }

        if (currentRow >= n) {
            int m = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (visited[i][j]) { m++; }
                }
            }

            if (max_Black < m) { max_Black = m; }
            return;
        }

        if (!visited[currentRow][currentCol] && map[currentRow][currentCol] == 1 && searchArroundBishop(visited, currentRow, currentCol)) {
            visited[currentRow][currentCol] = true;
            dfs_black(visited, currentRow, currentCol+2);
            visited[currentRow][currentCol] = false;
        }

        dfs_black(visited, currentRow, currentCol+2);
    }

    static boolean searchArroundBishop(boolean[][] visited, int currentRow, int currentCol) {
        int[][] direction = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 4; j++) {
                int nextRow = currentRow + i * direction[j][0];
                int nextCol = currentCol + i * direction[j][1];
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && visited[nextRow][nextCol]) {
                    return false;
                }
            }
        }
        return true;
    }
}
