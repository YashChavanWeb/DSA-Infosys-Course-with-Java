package Searching_Algs_10;

public class BinaryNoOfIterations {

    public static int iterations = 0;

    public static int searchElement(int elements[], int low, int high, int elementToBeSearched) {

        while (low <= high) {
            int mid = (low + high) / 2;
            if (elements[mid] == elementToBeSearched) {
                iterations++;
                return mid;
            } else if (mid < elementToBeSearched) {
                low = mid + 1;
                iterations++;
            } else {
                iterations++;
                high = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] elements = { 1, 23, 43, 46, 78, 90 };
        int elementToBeSearched = 43;

        int indexPosition = searchElement(elements, 0, elements.length - 1, elementToBeSearched);

        if (indexPosition == -1)
            System.out.println("Element not found!");
        else
            System.out.println("Element found at index position " + indexPosition + "!");

        System.out.println("Number of iterations: " + iterations);
    }

}
