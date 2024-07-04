package Searching_Algs_10;

/*
 * Given an array of elements, check whether an element is present or not using Linear Search algorithm. If the element is found, return the number of iterations used for searching the element, else return -1. Implement the logic in searchElement() method.

Test the functionalities using the main() method of the Tester class.
 */

public class NumberOfIterations {
    public static int searchElement(int[] elements, int elementToBeSearched) {

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == elementToBeSearched) {
                return i + 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] elements = { 76, 24, 78, 98, 1 };
        int elementToBeSearched = 78;

        int numberOfIterations = searchElement(elements, elementToBeSearched);

        if (numberOfIterations == -1)
            System.out.println("Element not found!");
        else
            System.out.println(
                    "Element found! Number of iterations required to find the element : " + numberOfIterations);
    }
}
