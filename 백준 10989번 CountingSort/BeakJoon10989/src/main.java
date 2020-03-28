import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

// Counting Sort 방법 바로바로 저장을 하고 띄우기 때문에, 메모리를 절약할 수 있다.
public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int[] countingArray = new int[10001];

        int max = 0;
        int temp;
        for(int i = 0; i < size; i++) {
            temp = Integer.parseInt(br.readLine());
            countingArray[temp]++;
            if (temp > max) max = temp;
        }

        for(int i = 0; i <= max; i++) {
            for(int j = 0; j < countingArray[i]; j++) {
                bw.write( Integer.toString(i) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
