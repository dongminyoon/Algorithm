import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        main.size = n;

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }


        int[][] newBoard = excuteMove(board, "up");

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(newBoard[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static int[][] dfs(int restCount, int[][] currentBoard) {
        // 남은 숫자가 0일 경우 해당 CurrentBoard Return
        if(restCount == 0) { return currentBoard; }


        // 상하좌우 방향별로 실행시키기
        for(int i = 0; i < 4; i++) {
            String direction;
            if(i == 0) { direction = "up"; }
            else if(i == 1) { direction = "down"; }
            else if(i == 2) { direction = "left"; }
            else { direction = "right"; }
            dfs(restCount--, excuteMove(currentBoard, direction));
        }

        return currentBoard;
    }

    static int[][] excuteMove(int[][] currentBoard, String direction) {
        System.out.println(direction);
        if(direction == "up") {
            for(int j = 0; j < main.size; j++) {
                int currentSuccessIndex = 0;
                int row = 0;
                while (row < main.size) {
                    if(currentBoard[row][j] != 0 && row != main.size-1) {
                        int nextIndex = row+1;
                        while (nextIndex < main.size) {
                            if (currentBoard[nextIndex][j] != 0) {
                                if (currentBoard[nextIndex][j] != currentBoard[row][j]) {
                                    currentBoard[currentSuccessIndex++][j] = currentBoard[row][j];
                                    break;
                                }
                                else {
                                    currentBoard[currentSuccessIndex++][j] = 2 * currentBoard[row][j];
                                    currentBoard[nextIndex][j] = 0;
                                    if (nextIndex+1 < main.size) { row = nextIndex + 1; }
                                    break;
                                }
                            }
                            nextIndex++;
                        }
                    }

                    if (row == main.size-1) { currentBoard[currentSuccessIndex][j] = currentBoard[row][j]; }
                    row++;
                }
            }
        }

        return currentBoard;
    }
}
