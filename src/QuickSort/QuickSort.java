package QuickSort;

import java.util.Scanner;

public class QuickSort {

    public int[] numbers;
    public int number;

    public void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    public void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    public void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a collection of integers:");

        String input = sc.nextLine();

        String[] inputArray = input.split("");
        int[] myArray = new int[input.length()];

        for(int i = 0;i < inputArray.length;i++)
        {
            myArray[i] = Integer.parseInt(inputArray[i]);
        }


        System.out.println("Passing to Quicksort method....");
        QuickSort sorter = new QuickSort();
        sorter.sort(myArray);

        System.out.println("Here is the sorted collection:");
        for (int each : myArray){
            System.out.print(each);
        }

    }

}
