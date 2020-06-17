package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        int restMoney = 1000 - n;

        while(true) {
            if(restMoney <= 0) { break; }

            if(restMoney >= 500) { restMoney -= 500; }
            else if(restMoney >= 100) { restMoney -= 100; }
            else if(restMoney >= 50) { restMoney -= 50; }
            else if(restMoney >= 10) { restMoney -= 10; }
            else if(restMoney >= 5) { restMoney -= 5; }
            else { restMoney -= 1; }

            count++;
        }

        System.out.println(count);
    }
}
