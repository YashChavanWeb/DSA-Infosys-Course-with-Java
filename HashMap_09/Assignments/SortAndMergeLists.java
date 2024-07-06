package HashMap_09.Assignments;

import java.util.*;

/*
 * Given two sorted linked lists containing integers, return a single linked list containing all the integers of both the lists in a sorted order. Implement the logic inside mergeLists() method.
 */

public class SortAndMergeLists {
    public static List<Integer> mergeLists(List<Integer> listOne, List<Integer> listTwo) {
        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;
        while (i < listOne.size() && j < listTwo.size()) {
            if (listOne.get(i) <= listTwo.get(j)) {
                result.add(listOne.get(i));
                i++;
            } else {
                result.add(listTwo.get(j));
                j++;
            }
        }

        // Add remaining elements from listOne
        while (i < listOne.size()) {
            result.add(listOne.get(i));
            i++;
        }

        // Add remaining elements from listTwo
        while (j < listTwo.size()) {
            result.add(listTwo.get(j));
            j++;
        }

        return result;
    }

    public static void main(String args[]) {
        List<Integer> listOne = new LinkedList<Integer>();
        listOne.add(10);
        listOne.add(13);
        listOne.add(21);
        listOne.add(42);
        listOne.add(56);

        List<Integer> listTwo = new LinkedList<Integer>();
        listTwo.add(15);
        listTwo.add(20);
        listTwo.add(21);
        listTwo.add(85);
        listTwo.add(92);

        List<Integer> mergedList = mergeLists(listOne, listTwo);
        System.out.println(mergedList);
    }
}
