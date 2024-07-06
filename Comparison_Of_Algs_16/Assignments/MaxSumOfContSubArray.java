package Comparison_Of_Algs_16.Assignments;

/*
 * Given an array of integers, find and return the maximum sum that can be obtained using contiguous subarrays of the array using Divide and Conquer technique. Implement the logic in findMaxSum() method. To implement the logic, you need to also calculate the maximum sum of the subarray containing the middle element. You need to implement the logic of calculating the maximum sum of the subarray containing the middle element findMaxCrossingSubarraySum() method. 
 */

public class MaxSumOfContSubArray {

    public static int[][] multiply(int[][] matrixA,     int[][] matrixB) {
        int n = matrixA.length;
        int[][] result = new int[n][n];

        // Brute force multiplication
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrixA = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] matrixB = {
                { 9, 8, 7 },
                { 6, 5, 4 },
                { 3, 2, 1 }
        };

        System.out.println("Matrix A:");
        displayMatrix(matrixA);

        System.out.println("Matrix B:");
        displayMatrix(matrixB);

        int[][] result = multiply(matrixA, matrixB);

        System.out.println("Product of Matrix A and Matrix B:");
        displayMatrix(result);
    }
}