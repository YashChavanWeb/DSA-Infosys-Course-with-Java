package Comparison_Of_Algs_16.Assignments;

/*
 * Given a string which consists of '(' and ')', find out and return the total number of swaps required for the string to be balanced using greedy approach. Implement the logic in findSwapCount() method. 
 */

public class SwapsToBalanceAString {

    public static int findSwapCount(String inputString) {
        int openCount = 0; // Count of '('
        int unmatchedClose = 0; // Count of ')' unmatched by '('
        int swapCount = 0; // Number of swaps needed

        // Iterate through the string
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                if (openCount > 0) {
                    // Match this ')' with a '('
                    openCount--;
                } else {
                    // No '(' available to match, need a swap
                    unmatchedClose++;
                }
            }
        }

        // Number of swaps required is equal to unmatchedClose
        swapCount = unmatchedClose;

        return swapCount;
    }

    public static void main(String args[]) {
        String inputString = "())()(";
        System.out.println("Number of swaps: " + findSwapCount(inputString));
    }

}