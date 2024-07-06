package Sorting_Algs_14.Assignments;

/*
 * Given an array of size 'n', sort the array in ascending order using Merge Sort algorithm and find out the median value. The median is the value that is present in the middle of a sorted array containing odd number of values. If the sorted array contains even number of values, median is the average of middle two values.


 */

public class FindMedian {

    public static void mergeSort(int[] elements, int size) {
        if (size < 2) {
            return; // Base case: array of size 1 is already sorted
        }

        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        // Populate left and right arrays
        for (int i = 0; i < mid; i++) {
            left[i] = elements[i];
        }
        for (int i = mid; i < size; i++) {
            right[i - mid] = elements[i];
        }

        // Recursive calls to mergeSort for left and right halves
        mergeSort(left, mid);
        mergeSort(right, size - mid);

        // Merge the sorted halves
        merge(elements, left, right, mid, size - mid);
    }

    public static void merge(int[] elements, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;

        // Merge left and right arrays into elements
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                elements[k++] = left[i++];
            } else {
                elements[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[] if any
        while (i < leftSize) {
            elements[k++] = left[i++];
        }

        // Copy remaining elements of right[] if any
        while (j < rightSize) {
            elements[k++] = right[j++];
        }
    }

    public static double findMedian(int[] elements) {
        int n = elements.length;
        int mid = n / 2;

        if (n % 2 == 1) {
            // Odd number of elements
            return elements[mid];
        } else {
            // Even number of elements
            return (elements[mid - 1] + elements[mid]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] elements = { 64, 34, 25, 12, 22, 11, 90 };

        // Sort the array using Merge Sort
        mergeSort(elements, elements.length);

        // Print the sorted array
        System.out.print("Sorted Array: ");
        for (int num : elements) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Find and print the median
        System.out.println("Median: " + findMedian(elements));
    }
}