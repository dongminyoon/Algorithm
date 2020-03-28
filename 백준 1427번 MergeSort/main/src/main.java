import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    int[] data;

    public main(int[] data) {
        this.data = data;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");
        int[] notSortedArray = new int[input.length];
        for(int i = 0; i < notSortedArray.length; i++) { notSortedArray[i] = Integer.parseInt(input[i]); }
        main main = new main(notSortedArray);

        main.mergeSort(0, notSortedArray.length-1);
        for(int i = 0; i < main.data.length; i++) {
            System.out.print(main.data[i]);
        }
    }

    public void mergeSort(int firstIndex, int lastIndex) {
        int middleIndex = (firstIndex + lastIndex) / 2;

        if(firstIndex < lastIndex) {
            mergeSort(firstIndex, middleIndex);
            mergeSort(middleIndex + 1, lastIndex);
            merge(firstIndex, middleIndex, lastIndex);
        }
    }

    public void merge(int firstIndex, int middleIndex, int lastIndex) {
        int i = firstIndex, k = firstIndex;
        int j = middleIndex + 1;
        int[] temp = new int[data.length];

        while (i <= middleIndex && j <= lastIndex) {
            if(data[i] >= data[j])
                temp[k++] = data[i++];
            else
                temp[k++] = data[j++];
        }

        while (i <= middleIndex)
            temp[k++] = data[i++];
        while (j <= lastIndex)
            temp[k++] = data[j++];

        for(int l = firstIndex; l <= lastIndex; l++)
            data[l] = temp[l];
    }
}
