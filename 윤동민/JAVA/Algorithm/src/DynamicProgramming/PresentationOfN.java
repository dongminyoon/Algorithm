package DynamicProgramming;
import java.util.*;

public class PresentationOfN {

    public int solution(int N, int number) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> DP = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            DP.add(new ArrayList<>());
            String integ = "";
            for (int j = 0; j < i+1; j++)
                integ += Integer.toString(N);

            int castingInt = Integer.parseInt(integ);
            if (castingInt == number) return i+1;
            DP.get(i).add(castingInt);

            if (i == 0) continue;
            for (int j = 0; j < DP.get(i-1).size(); j++) {
                int preNum = DP.get(i-1).get(j);

                DP.get(i).add(preNum + N);
                DP.get(i).add(preNum * N);
                DP.get(i).add(preNum / N);
                if (preNum - N > 0) DP.get(i).add(preNum - N);
                if (N - preNum > 0) DP.get(i).add(N - preNum);
                if (preNum > 0) DP.get(i).add(N / preNum);
            }

            for (int k = 0; k < DP.get(i).size(); k++) {
                int temp = DP.get(i).get(k);
                if (temp == number) return i+1;
            }
        }

        return -1;
    }

}
