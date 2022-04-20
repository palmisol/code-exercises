import java.util.Arrays;

public class SelectionSort {


    public SelectionSort(int[] input) {

        for (int lastUnsortedIndex = input.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            int largest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (input[i] > input[largest]) {
                    largest = i;
                }
            }
            swap(input, largest, lastUnsortedIndex);

        }
        System.out.println(Arrays.toString(input));
    }

    private void swap(int[] array, int i, int j) {

        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
