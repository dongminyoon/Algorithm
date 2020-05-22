import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;
        int k;
        int[] sample;

        do {
            input = br.readLine().split(" ");
            k = Integer.parseInt(input[0]);
            if (k == 0) break;
            sample = new int[k];
            for(int i = 1; i <=k; i++) { sample[i-1] = Integer.parseInt(input[i]); }

            for(int i = 0; i < k; i++) { System.out.println(sample[i] + " "); }
        } while (true);
    }

    static void dfs(int n) {

    }
}
