import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;

public class main {
    // 북,동,남,서
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        // n = 세로 크기 height, m = 가로 크기 width
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int robotY = Integer.parseInt(input[0]);
        int robotX = Integer.parseInt(input[1]);
        int robotDir = Integer.parseInt(input[2]);

        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs(n, m, map, robotX, robotY, robotDir);
    }

    static void bfs(int n, int m, int[][] map, int currentX, int currentY, int currentDir) {
        LinkedList<Integer> queueX = new LinkedList<>();
        LinkedList<Integer> queueY = new LinkedList<>();
        LinkedList<Integer> queueDir = new LinkedList<>();

        queueX.add(currentX);
        queueY.add(currentY);
        queueDir.add(currentDir);

        boolean[][] visited = new boolean[n][m];
        visited[currentY][currentX] = true;

        while (!queueX.isEmpty()) {
            int tempX = queueX.remove(0);
            int tempY = queueY.remove(0);
            int tempDir = queueDir.remove(0);

            int nextX, nextY, nextDir;
            boolean isOk = false;

            // 현재방향부터 왼쪽으로 탐색
            for(int i = 3; i >= 0; i--) {
                nextDir = (tempDir+i)%4;
                nextX = tempX+direction[nextDir][1];
                nextY = tempY+direction[nextDir][0];
                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && map[nextY][nextX] == 0 && !visited[nextY][nextX]) {
                    queueX.add(nextX);
                    queueY.add(nextY);
                    queueDir.add(nextDir);
                    visited[nextY][nextX] = true;
                    isOk = true;
                    break;
                }
            }

            // 모든 방향을 탐색했는데, 갈 곳이 없는 경우 뒤로 후
            if(!isOk) {
                nextX = tempX-direction[tempDir][1];
                nextY = tempY-direction[tempDir][0];

                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && map[nextY][nextX] == 0) {
                    queueX.add(nextX);
                    queueY.add(nextY);
                    queueDir.add(tempDir);
                }
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j]) { count++; }
            }
        }

        System.out.println(count);
    }
}
