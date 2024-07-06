package Sorting_Algs_14.Bubble_Sort_Exercies;

/*
 * Given an array of elements, implement the bubble sort algorithm to sort the elements in ascending order. 

Implement the functionalities based on the description given below.

Method Description

The displayArray() method is implemented and provided which displays the elements of the array

swap(int[] elements, int firstIndex, int secondIndex)

Swap the elements of the input array (elements) based on the index positions passed to the method

bubbleSort(int[] elements)

Sort the array of elements using the bubble sort algorithm and return the number of passes

Display the elements of the array after every pass by invoking the displayArray() method
 */

public class NoOfPassesAndSwaps {
    static int noOfSwaps = 0;
    static int noOfPasses = 0;

    public static void swap(int[] elements, int firstIndex, int secondIndex) {
        // Check if indices are valid
        if (firstIndex >= 0 && firstIndex < elements.length &&
                secondIndex >= 0 && secondIndex < elements.length) {
            // Perform the swap
            int temp = elements[firstIndex];
            elements[firstIndex] = elements[secondIndex];
            elements[secondIndex] = temp;
            noOfSwaps++;
        }
    }

    public static int bubbleSort(int[] elements) {
        int n = elements.length;
        boolean swapped;
        noOfPasses = 0;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    // Swap elements j and j+1
                    swap(elements, j, j + 1);
                    swapped = true;
                }
            }
            noOfPasses++;
            System.out.print("Pass " + noOfPasses + ": ");
            displayArray(elements);

            // If no elements were swapped in this pass, array is already sorted
            if (!swapped) {
                break;
            }
        }

        return noOfPasses;
    }

    public static void displayArray(int[] elements) {
        for (int element : elements)
            System.out.print(element + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] elements = { 23, 67, 45, 76, 34, 68, 90 };

        System.out.println("Given array:");
        displayArray(elements);

        int noOfPasses = bubbleSort(elements);

        System.out.println("==========================");
        System.out.println("Total number of passes needed to sort the array: " + noOfPasses);
        System.out.println("Total number of swaps performed: " + noOfSwaps);
        System.out.println("==========================");

        System.out.println("Array after sorting:");
        displayArray(elements);
    }
}
