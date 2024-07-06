package Algs_Techniques_15.Brute_Force.Exercises;

/*
 * Given a number 'num' and a power 'p', find and return the exponent of 'num' raised to the power 'p' using brute force technique. Implement the logic inside calculatePower() method.
Note: Do not use the Math.pow() method
 */

public class ExponentOfNoBruteForce {

    public static int calculatePower(int num, int p) {
        if (p == 0) {
            return 1; // Any number to the power of 0 is 1
        }

        int result = 1;
        for (int i = 0; i < p; i++) {
            result *= num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculatePower(2, 3)); // Output: 8 (since 2^3 = 2 * 2 * 2 = 8)
        System.out.println(calculatePower(0, 10)); // Output: 1 (since any number^0 = 1)
    }
}