import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BAEKJOON12100 {
    static int size;
    static ArrayList<Integer> boards = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        BAEKJOON12100.size = n;

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(5, board);
//
        Collections.reverse(boards);

        System.out.println(boards.get(0));
    }

    static void dfs(int restCount, int[][] currentBoard) {
        // 남은 숫자가 0일 경우 해당 CurrentBoard Return
        if(restCount == 0) {
            int max = 0;
            for(int i = 0; i < BAEKJOON12100.size; i++) {
                for(int j = 0; j < BAEKJOON12100.size; j++) {
                    if(currentBoard[i][j] > max) { max = currentBoard[i][j]; }
                }
            }
            boards.add(max);
            return ;
        }

        int[][] tempBoard = currentBoard;
        dfs(restCount-1, excuteMove(tempBoard, "up"));
        dfs(restCount-1, excuteMove(tempBoard, "down"));
        dfs(restCount-1, excuteMove(tempBoard, "left"));
        dfs(restCount-1, excuteMove(tempBoard, "right"));
    }

    static int[][] excuteMove(int[][] currentBoard, String direction) {
        if(direction == "up") {
            for(int j = 0; j < BAEKJOON12100.size; j++) {
                int currentSuccessIndex = 0;
                int row = 0;
                while (row < BAEKJOON12100.size) {
                    if(currentBoard[row][j] != 0 && row != BAEKJOON12100.size-1) {
                        int nextIndex = row+1;
                        while (nextIndex < BAEKJOON12100.size) {
                            if (currentBoard[nextIndex][j] != 0) {
                                if (currentBoard[nextIndex][j] != currentBoard[row][j]) {
                                    currentBoard[currentSuccessIndex++][j] = currentBoard[row][j];
                                    break;
                                } else {
                                    currentBoard[currentSuccessIndex++][j] = 2 * currentBoard[row][j];
                                    currentBoard[nextIndex][j] = 0;
//                                    if (nextIndex+1 < Main.size) { row = nextIndex + 1; }
                                    if (nextIndex+1 < BAEKJOON12100.size) { row = nextIndex; }
                                    break;
                                }
                            } else {
                                if (nextIndex == BAEKJOON12100.size-1) {
                                    currentBoard[currentSuccessIndex++][j] = currentBoard[row][j];
                                    break;
                                }
                            }
                            nextIndex++;
                        }
                    }

                    if (row == BAEKJOON12100.size-1) { currentBoard[currentSuccessIndex++][j] = currentBoard[row][j]; }
                    row++;
                }

                for(int k = currentSuccessIndex; k < BAEKJOON12100.size; k++) { currentBoard[k][j] = 0; }
            }
        } else if(direction == "down") {
            for(int j = 0; j < BAEKJOON12100.size; j++) {
                int currentSuccessIndex = BAEKJOON12100.size-1;
                int row = BAEKJOON12100.size-1;
                while (row >= 0) {
                    if(currentBoard[row][j] != 0 && row != 0) {
                        int nextIndex = row-1;
                        while (nextIndex >= 0) {
                            if (currentBoard[nextIndex][j] != 0) {
                                if (currentBoard[nextIndex][j] != currentBoard[row][j]) {
                                    currentBoard[currentSuccessIndex--][j] = currentBoard[row][j];
                                    break;
                                } else {
                                    currentBoard[currentSuccessIndex--][j] = 2 * currentBoard[row][j];
                                    currentBoard[nextIndex][j] = 0;
//                                    if (nextIndex-1 >= 0) { row = nextIndex - 1; }
                                    if (nextIndex-1 >= 0) { row = nextIndex; }
                                    break;
                                }
                            } else {
                                if (nextIndex == 0) {
                                    currentBoard[currentSuccessIndex--][j] = currentBoard[row][j];
                                    break;
                                }
                            }
                            nextIndex--;
                        }
                    }

                    if (row == 0) { currentBoard[currentSuccessIndex--][j] = currentBoard[row][j]; }
                    row--;
                }

                for(int k = currentSuccessIndex; k >= 0; k--) { currentBoard[k][j] = 0; }
            }
        } else if(direction == "left") {
            for(int i = 0; i < BAEKJOON12100.size; i++) {
                int currentSuccessIndex = 0;
                int col = 0;
                while (col < BAEKJOON12100.size) {
                    if(currentBoard[i][col] != 0 && col != BAEKJOON12100.size-1) {
                        int nextIndex = col+1;
                        while (nextIndex < BAEKJOON12100.size) {
                            if (currentBoard[i][nextIndex] != 0) {
                                if (currentBoard[i][nextIndex] != currentBoard[i][col]) {
                                    currentBoard[i][currentSuccessIndex++] = currentBoard[i][col];
                                    break;
                                } else {
                                    currentBoard[i][currentSuccessIndex++] = 2 * currentBoard[i][col];
                                    currentBoard[i][nextIndex] = 0;
//                                    if (nextIndex+1 < Main.size) { col = nextIndex + 1; }
                                    if (nextIndex+1 < BAEKJOON12100.size) { col = nextIndex; }
                                    break;
                                }
                            } else {
                                if (nextIndex == BAEKJOON12100.size-1) {
                                    currentBoard[i][currentSuccessIndex++] = currentBoard[i][col];
                                    break;
                                }
                            }
                            nextIndex++;
                        }
                    }

                    if (col == BAEKJOON12100.size-1) { currentBoard[i][currentSuccessIndex++] = currentBoard[i][col]; }
                    col++;
                }

                for(int k = currentSuccessIndex; k < BAEKJOON12100.size; k++) { currentBoard[i][k] = 0; }
            }
        } else {
            for(int i = 0; i < BAEKJOON12100.size; i++) {
                int currentSuccessIndex = BAEKJOON12100.size-1;
                int col = BAEKJOON12100.size-1;
                while (col >= 0) {
                    if(currentBoard[i][col] != 0 && col != 0) {
                        int nextIndex = col-1;
                        while (nextIndex >= 0) {
                            if (currentBoard[i][nextIndex] != 0) {
                                if (currentBoard[i][nextIndex] != currentBoard[i][col]) {
                                    currentBoard[i][currentSuccessIndex--] = currentBoard[i][col];
                                    break;
                                } else {
                                    currentBoard[i][currentSuccessIndex--] = 2 * currentBoard[i][col];
                                    currentBoard[i][nextIndex] = 0;
//                                    if (nextIndex-1 >= 0) { col = nextIndex - 1; }
                                    if (nextIndex-1 >= 0) { col = nextIndex; }
                                    break;
                                }
                            } else {
                                if (nextIndex == 0) {
                                    currentBoard[i][currentSuccessIndex--] = currentBoard[i][col];
                                    break;
                                }
                            }
                            nextIndex--;
                        }
                    }

                    if (col == 0) { currentBoard[i][currentSuccessIndex--] = currentBoard[i][col]; }
                    col--;
                }

                for(int k = currentSuccessIndex; k >= 0; k--) { currentBoard[i][k] = 0; }
            }
        }

        return currentBoard;
    }
}
