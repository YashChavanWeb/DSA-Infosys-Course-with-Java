package Sorting_Algs_14.Merge_Sort_Exercises;

/*
 * Given an array of elements, implement the merge sort algorithm to sort the
 * elements in ascending order.
 * Implement the functionalities based on the description given below.
 * Method Description
 * The displayArray() method is implemented and provided which displays the
 * elements of the array
 * mergeSort(int[] elements, int size)
 * Sort the array using the merge sort algorithm
 * merge(int[] elements, int[] left, int[] right, int leftMerge, int rightMerge)
 * Merge the left array and right array to produce new sorted arraysGiven an
 * array of elements, implement the merge sort algorithm to sort the elements in
 * ascending order.
 * Implement the functionalities based on the description given below.
 * Method Description
 * The displayArray() method is implemented and provided which displays the
 * elements of the array
 * mergeSort(int[] elements, int size)
 * Sort the array using the merge sort algorithm
 * merge(int[] elements, int[] left, int[] right, int leftMerge, int rightMerge)
 * Merge the left array and right array to produce new sorted arrays
 */

public class ImplementMergeSort {

    public static void mergeSort(int[] elements, int size) {
        if (size <= 1) {
            return; // Array is already sorted
        }

        // Find the middle point
        int mid = size / 2;

        // Create left and right subarrays
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        // Copy data to left and right subarrays
        System.arraycopy(elements, 0, left, 0, mid);
        System.arraycopy(elements, mid, right, 0, size - mid);

        // Recursively sort left and right subarrays
        mergeSort(left, mid);
        mergeSort(right, size - mid);

        // Merge the sorted left and right subarrays
        merge(elements, left, right, mid, size - mid);
    }

    public static void merge(int[] elements, int[] left, int[] right, int leftMerge, int rightMerge) {
        int i = 0, j = 0, k = 0;

        // Merge left and right arrays into elements
        while (i < leftMerge && j < rightMerge) {
            if (left[i] <= right[j]) {
                elements[k++] = left[i++];
            } else {
                elements[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[] if any
        while (i < leftMerge) {
            elements[k++] = left[i++];
        }

        // Copy remaining elements of right[] if any
        while (j < rightMerge) {
            elements[k++] = right[j++];
        }
    }

    public static void displayArray(int[] elements) {
        for (int element : elements)
            System.out.print(element + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] elements = { 95, 56, 20, 98, 34, 77, 80 };

        System.out.println("Given Array:");
        displayArray(elements);

        mergeSort(elements, elements.length);

        System.out.println("Sorted Array:");
        displayArray(elements);
    }
}
