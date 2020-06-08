import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BAEKJOON6603 {
    static int[] sample;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;
        int k;

        do {
            input = br.readLine().split(" ");
            k = Integer.parseInt(input[0]);
            if (k == 0) break;
            BAEKJOON6603.sample = new int[k];

            for(int i = 1; i <=k; i++) { sample[i-1] = Integer.parseInt(input[i]); }

            for(int i = 0; i < k; i++) {
                ArrayList<Integer> lotto = new ArrayList<>();
                lotto.add(sample[i]);
                dfs(lotto, i+1);
            }
            System.out.println("");
        } while (true);
    }


    static void dfs(ArrayList<Integer> lotto, int index) {
        if (lotto.size() == 6) {
            for(int i = 0; i  < 6; i++) { System.out.print(lotto.get(i) + " "); }
            System.out.println("");
            return;
        }

        for(int i = index; i < sample.length; i++) {
            lotto.add(sample[i]);
            dfs(lotto, i+1);
            lotto.remove(lotto.size()-1);
        }
    }
}
