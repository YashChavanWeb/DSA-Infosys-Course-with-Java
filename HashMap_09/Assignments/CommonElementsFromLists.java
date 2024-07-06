package HashMap_09.Assignments;

import java.util.*;

/*
 * Given two linked lists that store integer values, return a linked list containing the common elements from both the lists. Implement the logic inside findCommonElements() method.
 */

public class CommonElementsFromLists {

    public static List<Integer> findCommonElements(List<Integer> listOne, List<Integer> listTwo) {

        /* Using List */

        // List<Integer> result = new ArrayList<>();

        // for (Integer one : listOne) {

        // for (Integer two : listTwo) {
        // if (one == two) {
        // result.add(two);
        // }
        // }

        // }

        // return result;

        /* Using HashSet */

        Set<Integer> setOne = new HashSet<>(listOne); // converting list to set
        Set<Integer> setTwo = new HashSet<>(listTwo);

        // Use retainAll to find intersection
        setOne.retainAll(setTwo);

        // Convert set back to list
        List<Integer> result = new ArrayList<>(setOne);

        return result;
    }

    public static void main(String args[]) {

        List<Integer> listOne = new LinkedList<Integer>();
        listOne.add(10);
        listOne.add(12);
        listOne.add(21);
        listOne.add(1);
        listOne.add(53);

        List<Integer> listTwo = new LinkedList<Integer>();
        listTwo.add(11);
        listTwo.add(21);
        listTwo.add(25);
        listTwo.add(53);
        listTwo.add(47);

        System.out.println(findCommonElements(listOne, listTwo));
    }
}
