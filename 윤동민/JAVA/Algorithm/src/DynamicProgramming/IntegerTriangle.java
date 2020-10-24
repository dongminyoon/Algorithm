package DynamicProgramming;

public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] DP = new int[triangle.length][];
        DP[0] = new int[triangle[0].length];
        DP[0][0] = triangle[0][0];

        System.out.println(DP[0][0]);

        for (int i = 1; i < triangle.length; i++) {
            DP[i] = new int[i+1];
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    DP[i][j] += DP[i-1][0] + triangle[i][j];
                } else if (j == triangle[i].length-1) {
                    DP[i][j] = DP[i-1][j-1] + triangle[i][j];
                } else {
                    DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + triangle[i][j];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < DP.length; i++)
            if (max < DP[DP.length-1][i]) max = DP[DP.length-1][i];

        return max;
    }
}
