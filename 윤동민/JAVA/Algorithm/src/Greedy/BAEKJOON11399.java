package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BAEKJOON11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] waiting_Time = new int[n];

        for(int i = 0; i < n; i++) { waiting_Time[i] = Integer.parseInt(input[i]); }


        int[] each_waiting_time = new int[n];
        boolean[] visited = new boolean[n];
        int total = 0;

        while(true) {
            int min = 1001;
            int min_index = -1;

            // 최솟값을 가진 waiting time을 찾는 과정
           for(int i  = 0; i < n; i++) {
                if(!visited[i]) {
                    if(min > waiting_Time[i]) {
                        min = waiting_Time[i];
                        min_index = i;
                    }
                }
            }

            // 모든 경우를 다 더한 경
            if(min_index == -1) { break; }

            visited[min_index] = true;
            total += waiting_Time[min_index];
            each_waiting_time[min_index] = total;
        }


        total = 0;
        for(int i = 0; i < n; i++) { total += each_waiting_time[i]; }

        System.out.println(total);
    }
}
