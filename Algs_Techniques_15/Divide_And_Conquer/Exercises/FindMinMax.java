package Algs_Techniques_15.Divide_And_Conquer.Exercises;

public class FindMinMax {

    public static int[] getMaxMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE };
        }

        // Call the helper function to recursively find max and min
        return getMaxMinHelper(arr, 0, arr.length - 1);
    }

    private static int[] getMaxMinHelper(int[] arr, int left, int right) {
        int[] result = new int[2];

        // Base case: Array has one element
        if (left == right) {
            result[0] = arr[left]; // Maximum
            result[1] = arr[left]; // Minimum
            return result;
        }

        // Base case: Array has two elements
        if (right == left + 1) {
            if (arr[left] > arr[right]) {
                result[0] = arr[left]; // Maximum
                result[1] = arr[right]; // Minimum
            } else {
                result[0] = arr[right]; // Maximum
                result[1] = arr[left]; // Minimum
            }
            return result;
        }

        // Divide the array into two halves
        int mid = left + (right - left) / 2;
        int[] leftMinMax = getMaxMinHelper(arr, left, mid);
        int[] rightMinMax = getMaxMinHelper(arr, mid + 1, right);

        // Merge the results
        result[0] = Math.max(leftMinMax[0], rightMinMax[0]); // Maximum
        result[1] = Math.min(leftMinMax[1], rightMinMax[1]); // Minimum

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1000, 1, 5, 1, 2000 };
        int[] arr2 = { 2, 3 };

        int[] result1 = getMaxMin(arr1);
        System.out.println("Maximum value in arr1: " + result1[0]); // Output: 2000
        System.out.println("Minimum value in arr1: " + result1[1]); // Output: 1

        int[] result2 = getMaxMin(arr2);
        System.out.println("Maximum value in arr2: " + result2[0]); // Output: 3
        System.out.println("Minimum value in arr2: " + result2[1]); // Output: 2
    }
}
