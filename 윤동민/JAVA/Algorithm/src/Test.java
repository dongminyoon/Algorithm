
public class Test {


    public static void main(String[] args) {


    }

    public static int searchNumber(int target, int[] arr) {



        return 1;
    }

    public void partition(int[] arr, int left, int right) {
        if (left >= right) return;

        int middle = (left+right) / 2;


    }

    public int[] mergeSort(int[] arr, int left, int middle, int right) {
        int i = left, j = middle;
        int k = left;

        int[] cloneArr = arr;

        while (i <= middle && arr[i] < arr[j]) {
            cloneArr[k++] = arr[i++];
        }

        while (j <= right && arr[j] <= arr[i]) {
            cloneArr[k++] = arr[j++];
        }

        while (k <= right) {

        }
    }
}
