import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        solution(n, arr1, arr2);
    }

    static public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};

        int[][] decodeArr1 = decodeMap(n, arr1);
        int[][] decodeArr2 = decodeMap(n, arr2);

        answer = additionMap(n, decodeArr1, decodeArr2);

        for(int i = 0; i < n; i++)
            System.out.println(answer[i]);

        return answer;
    }

    static public int[][] decodeMap(int n, int[] arr) {
        int[][] decodeArr = new int[n][n];

        for(int i = 0; i < n; i++) {
            int temp = arr[i];
            for(int j = n-1; j>=0; j--) {
                decodeArr[i][j] = temp%2;
                temp /= 2;
            }
        }

        return decodeArr;
    }

    static public String[] additionMap(int n, int[][] decodeMap1, int[][] decodeMap2) {
        String[] resultMap = new String[n];
        for(int i = 0; i < n; i++) resultMap[i] = "";

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(decodeMap1[i][j] == 1 || decodeMap2[i][j] == 1) resultMap[i] += "#";
                else resultMap[i] += " ";
            }
        }
        return resultMap;
    }
}