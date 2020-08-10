package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sample {
    static int k;
    static int[] numberExample;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");

            k = Integer.parseInt(input[0]);
            if (k == 0) { break; }

            numberExample = new int[k];
            for(int i = 1; i <= k; i ++) numberExample[i-1] = Integer.parseInt(input[i]);

            for(int i = 0; k - 6 - i >= 0; i++) {
                ArrayList<Integer> lotto = new ArrayList<>();
                lotto.add(numberExample[i]);
                dfs(i+1, lotto);
            }
            System.out.println("");
        }
    }

    static void dfs(int index, ArrayList<Integer> lotto) {
        if (lotto.size() == 6) {
            for(int i = 0; i < 6; i++) { System.out.print(lotto.get(i) + " "); }
            System.out.println("");
            return;
        }

        if (k - index + lotto.size() < 6) { return; }

        for(int i = index; i < k; i++) {
            lotto.add(numberExample[i]);
            dfs(i+1, lotto);
            lotto.remove(lotto.size()-1);
        }
    }
}
