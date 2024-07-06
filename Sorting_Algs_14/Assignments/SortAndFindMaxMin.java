package Sorting_Algs_14.Assignments;

/*
 * Given an array of size 'n' and an integer 'm', sort the array in ascending order using Bubble Sort algorithm and find the maximum sum that can be obtained by summing 'm' integers of the array and the minimum sum that can be obtained by summing 'm' integers of the array. If the array does not have 'm' number of elements, return 0 as the maximum and minimum sum. Implement the logic of sorting the array, finding the maximum sum and finding the minimum sum in sortArray(), findMaxSum() and findMinSum() methods respectively.
 */

public class SortAndFindMaxMin {

    public static void sortArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int findMaxSum(int[] arr, int m) {
        int n = arr.length;
        if (m > n) {
            return 0; // Not enough elements to pick m elements
        }

        int maxSum = 0;
        for (int i = n - 1; i >= n - m; i--) {
            maxSum += arr[i];
        }
        return maxSum;
    }

    public static int findMinSum(int[] arr, int m) {
        int n = arr.length;
        if (m > n) {
            return 0; // Not enough elements to pick m elements
        }

        int minSum = 0;
        for (int i = 0; i < m; i++) {
            minSum += arr[i];
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

        // Sort the array using Bubble Sort
        sortArray(arr);

        // Test with different values of m
        int m1 = 4;
        int m2 = 3;

        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Maximum Sum for m=" + m1 + ": " + findMaxSum(arr, m1));
        System.out.println("Minimum Sum for m=" + m2 + ": " + findMinSum(arr, m2));
    }
}