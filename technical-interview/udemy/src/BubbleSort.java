import java.util.Arrays;

public class BubbleSort {
    int[] numbers;
    int index;
    int size;
    /**
     * @param input
     */
    public BubbleSort(int[] input){

       this.numbers = input;
       index = 0;
       size = input.length - 1;

       sortElements();
       System.out.println(Arrays.toString(numbers));

    }
    private void sortElements(){

        if(index < size){
            swapElementsAtIndex();
            index ++;
            sortElements();
        } else if ( index == size ) {
            size--;
            index = 0;
            sortElements();
        } else {
            System.out.println("SORTED");
        }

    }
    private void swapElementsAtIndex(){
        if (numbers[index + 1] < numbers[index]){
            int temp = numbers[index];
            numbers[index] = numbers[index + 1];
            numbers[index + 1] = temp;
        }
    }



}
