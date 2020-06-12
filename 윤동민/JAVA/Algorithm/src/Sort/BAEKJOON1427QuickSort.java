import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BAEKJOON1427QuickSort {
    int[] array;

    public BAEKJOON1427QuickSort(int[] array) {
        this.array = array;
    }

    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");
        int[] notSortedArray = new int[input.length];

        for(int i = 0; i < input.length; i++) {
            notSortedArray[i] = Integer.parseInt(input[i]);
        }

        BAEKJOON1427QuickSort main = new BAEKJOON1427QuickSort(notSortedArray);
        main.quickSort(0, input.length-1);

        for(int i = 0; i < notSortedArray.length; i++) {
            System.out.println(notSortedArray[i]);
        }

    }

    void quickSort(int left, int right) {
        if(left > right) return;

        int standard = partition(left, right);

        quickSort(left, standard-1);
        quickSort(standard+1, right);
}

    int partition(int left, int right) {
        int pivot = array[left];

        int i = left, j = right;
        int temp;

        while(i < j) {
            while(pivot < array[j]) {
                j--;
            }

            while(pivot >= array[i] && i < j) {
                i++;
            }

            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        array[left] = array[j];
        array[j] = pivot;

        return j;
    }
}
