package Algs_Techniques_15.Dynamic_Programming.Exercises;

/*
 * Given a rod of length 'n' and an array containing prices of pieces of each rod size, find the optimal way to cut the rod into smaller pieces to get the maximum price. The price of rod of size 'i' is present in index position 'i-1' of the array. E.g. - The price of rod of size 2 is present in index position 1 of the array. Implement the logic in cutRod() method. 
 */

public class CutIntoPiecesForMaxProfit {

    public static int cutRod(int[] price, int n) {
        if (price == null || price.length == 0 || n <= 0) {
            return 0;
        }

        // Create a DP array to store maximum prices
        int[] dp = new int[n + 1];

        // Initialize dp[0] to 0 (base case)
        dp[0] = 0;

        // Calculate maximum price for rod lengths from 1 to n
        for (int i = 1; i <= n; i++) {
            int maxPrice = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                maxPrice = Math.max(maxPrice, price[j - 1] + dp[i - j]);
            }
            dp[i] = maxPrice;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] price1 = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n1 = 4;

        int[] price2 = { 10, 24, 30, 40, 45 };
        int n2 = 5;

        System.out.println("Maximum price for rod of length " + n1 + ": " + cutRod(price1, n1)); // Output: 10 (for rod
                                                                                                 // lengths [2, 2])
        System.out.println("Maximum price for rod of length " + n2 + ": " + cutRod(price2, n2)); // Output: 50 (for rod
                                                                                                 // lengths [2, 3])
    }
}