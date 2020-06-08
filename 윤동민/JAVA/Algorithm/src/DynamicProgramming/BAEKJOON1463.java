import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BAEKJOON1463 {
    static int[] count = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        calculate(n);
        System.out.println(count[1]);

    }

    static public void calculate(int n) {
        if(n == 1) { return; }
        int number;
        if(n % 3 == 0) {
            number = n/3;
            if(count[number] != 0 && count[number] > count[n] + 1) {
                count[number] = count[n] + 1;
                calculate(number);
            } else if(count[number] == 0) {
                count[number] = count[n] + 1;
                calculate(number);
            }
        }

        if (n % 2 == 0) {
            number = n/2;
            if(count[number] != 0 && count[number] > count[n] + 1) {
                count[number] = count[n] + 1;
                calculate(number);
            } else if(count[number] == 0) {
                count[number] = count[n] + 1;
                calculate(number);
            }
        }

        if (n - 1 >= 0) {
            number = n-1;
            if(count[number] != 0 && count[number] > count[n] + 1) {
                count[number] = count[n] + 1;
                calculate(number);
            } else if (count[number] == 0) {
                count[number] = count[n] + 1;
                calculate(number);
            }
        }
    }
}
